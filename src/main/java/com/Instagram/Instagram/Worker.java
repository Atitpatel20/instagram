package com.Instagram.Instagram;

public class Worker {
    private long id;
    private String name;
    private String designation;

    public Worker(long id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }
}
