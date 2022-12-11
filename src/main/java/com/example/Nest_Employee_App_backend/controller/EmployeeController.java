package com.example.Nest_Employee_App_backend.controller;

import com.example.Nest_Employee_App_backend.dao.EmployeeDao;
import com.example.Nest_Employee_App_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao edao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeRegistration",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> EmployeeRegistration(@RequestBody Employee e)
    {
        String ename=String.valueOf(e.getName().toString());
        String dob=String.valueOf(e.getDob().toString());
        String address=String.valueOf(e.getAddress().toString());
        String phoneno=String.valueOf(e.getPhoneNo().toString());
        String emailid=String.valueOf(e.getEmailId().toString());
        String password=String.valueOf(e.getPassword().toString());

        System.out.println(e.getName());
        System.out.println(e.getDob());
        System.out.println(e.getAddress());
        System.out.println(e.getPhoneNo());
        System.out.println(e.getEmailId());
        System.out.println(e.getPassword());

        edao.save(e);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLogin",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> EmployeeLogin(@RequestBody Employee e)
    {
        String emailid=String.valueOf(e.getEmailId().toString());
        String password=String.valueOf(e.getPassword().toString());

        List<Employee> result= edao.LoginVerify(e.getEmailId(),e.getPassword());

        HashMap<String,String> map=new HashMap<>();

        if(result.size()==0)
        {
            map.put("status","Invalid");
        }
        else
        {
            map.put("status","success");
            map.put("id",String.valueOf(result.get(0).getId()));
        }

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeProfile",produces = "application/json",consumes = "application/json")
    public List<Employee> EmployeeProfile(@RequestBody Employee e)
    {
        String eid=String.valueOf(e.getId());
        System.out.println(eid);

        return (List<Employee>) edao.GetEmployeeProfile(e.getId());
    }


}
