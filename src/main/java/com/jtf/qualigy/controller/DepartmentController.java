package com.jtf.qualigy.controller;

import com.jtf.qualigy.entity.Department;
import com.jtf.qualigy.entity.IdContainer;
import com.jtf.qualigy.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class DepartmentController {

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(
            @Validated @RequestBody Department department) {
        logger.info("department values are :: " + department);
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/departmentsmultiple")
    public List<Department> saveAllDepartment(
            @Validated @RequestBody List<Department> departmentList) {
        logger.info("department values are :: " + departmentList);

        List<Department> departmentsResponse = (List<Department>) departmentService.saveAllDepartment(departmentList);
        return departmentsResponse;
    }

    @GetMapping("/findDept/{id}")
    public Department fetchDepartment(@PathVariable("id")
                                      Long departmentId) {

        return departmentService.findDepartmentId(departmentId);
    }

@PostMapping("/findAllByIds")
    public List<Department> getAllDepartments(@RequestBody List<IdContainer> idContainer) {
        List<Integer> ids = new ArrayList<>();
        for (IdContainer id : idContainer) {
            ids.add(id.getId());
        }
        List<Department> deptsResponse = (List<Department>) departmentService.getAllDepartments(ids);
        return deptsResponse;
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {

        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId) {

        return departmentService.updateDepartment(
                department, departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId) {

        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }

    @GetMapping("/countDept")
    public Long getCounts(){
    logger.info("departments count ::");
        return departmentService.getCounts();
    }

    @PostMapping("/deptExistCheck")
    public String departmentExist(@RequestBody Department department){
        Boolean bool =departmentService.departmentExist(department.getDepartmentId());
        if(bool){
            logger.info("The department is already exist");
            return "Department is exist !!";
        }
        return "Department is not exist";
    }
}
