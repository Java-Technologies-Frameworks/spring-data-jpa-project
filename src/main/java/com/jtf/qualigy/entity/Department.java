package com.jtf.qualigy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Long departmentId;
    @Column(name = "dept_name")
    private String departmentName;
    @Column(name = "dept_addrs")
    private String departmentAddress;
    @Column(name = "dept_code")
    private String departmentCode;
}
