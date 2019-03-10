package com.example.demo.java8.test;

import com.example.demo.java8.function.MyFileterEmployeeForSalary;
import com.example.demo.java8.function.MyFilterEmployeeForAge;
import com.example.demo.java8.function.MyPredicate;
import com.example.demo.java8.model.Employee;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author fhj
 * @version 1.0
 * @ClassName Testlamdba2
 * @Description TODO
 * @date 2019/3/10  15:24
 **/
public class Testlamdba2 {


    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //匿名内部类实现排序
    @Test
   public void tset (){

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }

   }

   @Test
    public void test2(){
        Collections.sort(emps,(x,y) ->{
            int status = Integer.compare(x.getAge(),y.getAge());
            return status;
        });

       for (Employee emp : emps) {
           System.out.println(emp);
       }

   }




   /*使用策略模式*/
   @Test
    public void test3(){
       Employee e = new Employee(101, "2e4r4r4", 18, 9999.99);
       List<Employee> es =new ArrayList<>(emps);
        es.add(null);
        e = null;
        List<Employee> list = filterEmployeeAge(es);
       for (Employee employee : list) {
           System.out.println(employee);
       }

   }

    /**
     * 获取Age小于35的雇员
     * @param emps1
     * @return
     */
   private List<Employee> filterEmployeeAge(List<Employee> emps1){
       List<Employee> list = new ArrayList<Employee>();
       if(emps1 != null && emps1.size() > 0){
           for (Employee employee : emps1) {
               if(employee != null && employee.getAge() < 35){
                   list.add(employee);
               }
           }
       }
       return list;

   }

    /**
     * 获取工资大于5000的雇员
     * @param eps
     * @return
     */
   private List<Employee> FilterEmployeeSalary(List<Employee> eps){
       List<Employee> list = new ArrayList<Employee>();
       if(eps != null && eps.size() > 0){
           for (Employee employee : eps) {
               if(employee != null && employee.getSalary() > 5000){
                   list.add(employee);
               }
           }
       }
       return list;
   }

   private List<Employee> FilterEmployee(List<Employee> eps, MyPredicate<Employee> my){
       List<Employee> list = new ArrayList<Employee>();
       if(eps != null && eps.size() > 0){
           for (Employee ep : eps) {
               if(ep != null && my.test(ep)){
                   list.add(ep);
               }
           }
       }
       return list;
   }

    /**
     * 使用策略模式实现过滤雇员
     */
   @Test
   public void test4(){
        List<Employee> list = FilterEmployee(emps,new MyFilterEmployeeForAge());
       for (Employee employee : list) {
           System.out.println(employee);
       }
       System.out.println("---------------------------");
       list = FilterEmployee(emps,new MyFileterEmployeeForSalary());
       for (Employee employee : list) {

           System.out.println(employee);
       }
   }

    /**
     * 使用lamdba表达式
     */
   @Test
   public void test5(){
       List<Employee> list = FilterEmployee(emps,(e) ->{
           if(e != null && e.getAge() <35){
               return true;
           }
           return false;
       });
       for (Employee employee : list) {
           System.out.println(employee);
       }
       System.out.println("--------------------------");
       list = FilterEmployee(emps,(e) ->{
           if(e != null && e.getSalary() > 5000){
               return true;
           }
           return false;
       });
       for (Employee employee : list) {

           System.out.println(employee);
       }
   }


    /**
     * 使用Stream流过滤
     */
   @Test
    public void test6(){
       emps.stream()
               .filter((e) -> e
               .getAge() < 35)
               .forEach(System.out :: println);
       System.out.println("----------------");
       emps.stream()
               .map(Employee::getName)
               .limit(2)
               .sorted()
               .forEach(System.out :: println);
       System.out.println("========================");
       emps.parallelStream()
               .forEach(System.out::println);
       System.out.println("========================");
       emps.parallelStream()
               .skip(2)
               .forEach(System.out::println);

   }

}
