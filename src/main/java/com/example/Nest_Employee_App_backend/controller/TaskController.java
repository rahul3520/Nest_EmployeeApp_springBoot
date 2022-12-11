package com.example.Nest_Employee_App_backend.controller;


import com.example.Nest_Employee_App_backend.dao.TaskDao;
import com.example.Nest_Employee_App_backend.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskDao tdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTask",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddTask(@RequestBody Tasks t)
    {
        String eid=String.valueOf(t.getEmpId());
        String taskname=String.valueOf(t.getTaskName().toString());
        String taskstatus=String.valueOf(t.getTaskStatus().toString());

        tdao.save(t);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewMyTasks",produces = "application/json",consumes = "application/json")
    public List<Tasks> ViewMyTask(@RequestBody Tasks t)
    {
        String eid=String.valueOf(t.getEmpId());

        System.out.println(eid);

        return (List<Tasks>) tdao.GetMyTask(t.getEmpId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllTasks")
    public List<Map<String,String>> ViewAllTasks()
    {
        return (List<Map<String, String>>) tdao.ViewTasksAllocated();
    }
}
