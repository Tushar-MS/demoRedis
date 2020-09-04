package com.democache.demoRedis.repository;

import com.democache.demoRedis.Model.Employee;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee find(Long id);
}

