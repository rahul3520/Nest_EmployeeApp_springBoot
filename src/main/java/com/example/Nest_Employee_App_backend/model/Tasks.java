package com.example.Nest_Employee_App_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empId;

    private String taskName;

    private String taskStatus;

    public Tasks() {
    }

    public Tasks(int id, int empId, String taskName, String taskStatus) {
        this.id = id;
        this.empId = empId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
