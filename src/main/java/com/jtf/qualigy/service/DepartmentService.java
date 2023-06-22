package com.jtf.qualigy.service;

import com.jtf.qualigy.entity.Department;
import com.jtf.qualigy.entity.IdContainer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);
    public List<Department> saveAllDepartment(List<Department> departmentList);

    List<Department> fetchDepartmentList();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department findDepartmentId(Long departmentId);

    List<Department> getAllDepartments(List<Integer> ids);

    public Long getCounts();

    public Boolean departmentExist(Long deptId);
}
