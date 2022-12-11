package com.example.Nest_Employee_App_backend.dao;

import com.example.Nest_Employee_App_backend.model.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Tasks,Integer> {

    @Query(value = "SELECT `id`, `emp_id`, `task_name`, `task_status` FROM `tasks` WHERE `emp_id`=:empId",nativeQuery = true)
    List<Tasks> GetMyTask(@Param("empId") int empId);


    @Query(value = "SELECT e.`id`, e.`address`, e.`dob`, e.`email_id`, e.`name`, e.`phone_no`,t.task_name,t.task_status FROM `employees` e JOIN tasks t ON e.id=t.emp_id",nativeQuery = true)
    List<Map<String,String>> ViewTasksAllocated();
}
