package com.iris.springStream.domain;

import java.io.Serializable;

/**
 * @Author iris
 * @date
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -527750971757183545L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
