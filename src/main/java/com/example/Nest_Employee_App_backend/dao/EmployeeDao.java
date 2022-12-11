package com.example.Nest_Employee_App_backend.dao;

import com.example.Nest_Employee_App_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `address`, `dob`, `email_id`, `name`, `password`, `phone_no` FROM `employees` WHERE `email_id`=:emailId AND `password`=:password",nativeQuery = true)
    List<Employee> LoginVerify(@Param("emailId") String emailId,@Param("password") String password);


    @Query(value = "SELECT `id`, `address`, `dob`, `email_id`, `name`,`password`, `phone_no` FROM `employees` WHERE `id`=:id",nativeQuery = true)
    List<Employee> GetEmployeeProfile(@Param("id") int id);
}
