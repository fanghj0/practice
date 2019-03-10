package com.example.demo.java8.function;

import com.example.demo.java8.model.Employee;

/**
 * @author fhj
 * @version 1.0
 * @ClassName MyFilterEmployeeForAge
 * @Description TODO
 * @date 2019/3/10  16:28
 **/
public class MyFilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        if(employee != null && employee.getAge() < 35){
            return true;
        }
        return false;
    }
}
