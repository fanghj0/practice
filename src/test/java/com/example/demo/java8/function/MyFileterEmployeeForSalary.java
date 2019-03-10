package com.example.demo.java8.function;

import com.example.demo.java8.model.Employee;

/**
 * @author fhj
 * @version 1.0
 * @ClassName MyFileterEmployeeForSalary
 * @Description TODO
 * @date 2019/3/10  16:31
 **/
public class MyFileterEmployeeForSalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        if(employee !=null && employee.getSalary() >5000){
            return true;
        }
        return false;
    }
}
