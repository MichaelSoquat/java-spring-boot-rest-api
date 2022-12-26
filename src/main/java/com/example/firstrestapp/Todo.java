package com.example.firstrestapp;

public class Todo {

    private Integer id;
    private String description;
    private boolean isDone;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setDescription(String desc) {
        this.description=desc;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDone(Boolean isDone) {
        this.isDone=isDone;
    }

    public Boolean getDone() {
        return this.isDone;
    }
}
