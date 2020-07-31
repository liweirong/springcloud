package com.iris.flowable.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iris.flowable.util.CommUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报销demoController
 *
 * @author iris
 * @date 2020-6-3
 */
@Api(description = "生产者进程API接口")
@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;

/***************此处为业务代码******************/
    /**
     * 添加报销
     *
     * @param userId    用户Id
     * @param money     报销金额
     * @param descption 描述
     */
    @ApiOperation(value = "添加报销")
    @PostMapping(value = "/add")
    public String addExpense(String userId, Integer money, String descption) {
        //启动流程
        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("money", money);
        map.put("descption", descption);
        repositoryService.createDeployment().tenantId("myTenantId").deploy();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Expense", map);
        return "提交成功.流程Id为：" + processInstance.getId();
    }

    /**
     * 获取审批管理列表
     */
    @ApiOperation(value = "获取审批管理列表")
    @PostMapping(value = "/list/{userId}")
    public List<Map<String, Object>> list(@PathVariable("userId") String userId) {
        List<Map<String, Object>> listMap = new ArrayList<>();

        runtimeService.createProcessInstanceQuery().processInstanceTenantId("myTenantId");

        List<Task> tasks = taskService.createTaskQuery()
//                .processInstanceTenantId("myTenantId")
                .processInstanceId("myTenantId")
    .taskAssignee(userId).orderByTaskCreateTime().desc().list();

        for (Task task : tasks) {
            System.out.println(task.toString());
            listMap.add(CommUtil.obj2map(task));
        }
        return listMap;
    }

    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @ApiOperation(value = "批准")
    @PostMapping(value = "/apply/{taskId}")
    public String apply(@PathVariable("taskId") String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("outcome", "通过");
//        runtimeService.createProcessInstanceQuery().processInstanceTenantId("myTenantId");
        taskService.complete(taskId, map);
        return "processed ok!";
    }

    /**
     * 拒绝
     */
    @ApiOperation(value = "拒绝")
    @PostMapping(value = "/reject/{taskId}")
    public String reject(@PathVariable("taskId") String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("outcome", "驳回");
        taskService.complete(taskId, map);
        return "reject";
    }

    /**
     * 生成流程图
     *
     * @param processId 任务ID
     */
    @ApiOperation(value = "生成流程图")
    @GetMapping(value = "/processDiagram/{processId}")
    public void genProcessDiagram(HttpServletResponse httpServletResponse, @PathVariable("processId") String processId) throws Exception {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();

        //流程走完的不显示图
        if (pi == null) {
            return;
        }
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        //得到正在执行的Activity的Id
        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        ProcessEngineConfiguration engconf = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", activityIds, flows, engconf.getActivityFontName(), engconf.getLabelFontName(), engconf.getAnnotationFontName(), engconf.getClassLoader(), 1.0);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
