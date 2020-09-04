package com.democache.demoRedis.service;

import com.democache.demoRedis.Model.Employee;
import com.democache.demoRedis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EmployeeService implements EmployeeRepository {
    private static final String TABLE_NAME = "Employee";

    private final RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, Employee> hashOperations;

    @Autowired
    public EmployeeService(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate =  redisTemplate;
    }
    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(Employee employee){
        hashOperations.put(TABLE_NAME, employee.getId(), employee);
    }

    public Employee find(Long id) {
        return hashOperations.get(TABLE_NAME, id);
    }
}
