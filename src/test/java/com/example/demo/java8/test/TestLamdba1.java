package com.example.demo.java8.test;

import com.example.demo.java8.function.MyFunction2;
import com.example.demo.java8.function.Myfunction;
import com.example.demo.java8.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fhj
 * @version 1.0
 * @ClassName TestLamdba1
 * @Description TODO
 * @date 2019/3/10  14:31
 **/
public class TestLamdba1 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //测试lamdba排序
    @Test
    public void test1() {

        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                System.out.println(Integer.compare(e1.getAge(), e2.getAge()));
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }


    }

    @Test
    public void test2() {
        String str = "  bcvdn  kvndk    ";
        String st = strHandler(str, (s) -> s.trim());
        System.out.println(st);
         st = strHandler(st, (s) -> s.replace("b","*"));
        System.out.println(st);
    }


    private String strHandler(String str, Myfunction my) {

        return my.getValue(str);
    }

    @Test
    public void test3(){
        System.out.println(op(100,200,(x,y) -> x + y));
        System.out.println(op(10,1,(x,y) -> x * y));

    }

    public Integer op(int i1, int i2, MyFunction2<Integer,Integer> my){
        return my.getValue(i1,i2);
    }


}
