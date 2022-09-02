package com.meng.reggie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meng.reggie.entity.Employee;
import com.meng.reggie.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{
}
