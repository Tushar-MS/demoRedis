package com.democache.demoRedis.Resources;

import com.democache.demoRedis.Model.Employee;
import com.democache.demoRedis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class EmployeeResouceImpl {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void saveEmployeeInformation(@RequestBody Employee employee){
        employeeService.save(employee);
    }
    @Cacheable(value="com.demo.redis.empId", key="('emp').concat(#id)" )
    @GetMapping(path = "{id}")
    public Employee fetchEmployee(@PathVariable("id") long id) {
        return employeeService.find(id);
    }
}
