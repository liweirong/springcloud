# flowable-springboot

1.先启动好此项目，然后创建一个流程：

访问：http://localhost:8080/expense/add?userId=123&money=123321
返回：提交成功.流程Id为：5

 

2.查询待办列表:

访问：http://localhost:8080/expense/list?userId=123
输出：Task[id=2507, name=出差报销]

 

3.同意：

访问：http://localhost:8080/expense/apply?taskId=11

返回：processed ok!

 

4.生成流程图：

访问：http://localhost:8080/expense/processDiagram?processId=5
返回：图片