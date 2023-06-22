package com.jtf.qualigy.service.impl;


import com.jtf.qualigy.entity.Department;
import com.jtf.qualigy.entity.IdContainer;
import com.jtf.qualigy.repository.DepartmentRepository;
import com.jtf.qualigy.service.DepartmentService;
import com.sun.deploy.security.BadCertificateDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        logger.info("service received department values :: "+department);
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> saveAllDepartment(List<Department> departmentList) {
        List<Department> response = (List<Department>) departmentRepository.saveAll(departmentList);
        return response;
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department findDepartmentId(Long departmentId) {
       return departmentRepository.findById(departmentId).get();
    }


    @Override
    public List<Department> getAllDepartments(List<Integer> departmentIdList) {
        List<Department> results = new ArrayList<>();
          if(departmentIdList.size()>0){
              for (Integer id : departmentIdList) {
                Optional optDepartment = departmentRepository.findById(Long.valueOf(id));
                if(optDepartment.isPresent())
                  results.add((Department) optDepartment.get());
              }
          }
        return results;
    }

    @Override
    public Long getCounts() {
        return departmentRepository.count();
    }

    @Override
    public Boolean departmentExist(Long deptId) {
        return departmentRepository.existsById(deptId);
    }
}
