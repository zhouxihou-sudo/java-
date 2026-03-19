package com.example.study.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 获取配置文件中的数据
    //
    @Value("${name}")    // 但是这里的名字必须和键名一样
    private String name; // 注意成员变量的名称和配置文件中的数据的键的名称没有任何关系
    @Value("${person.name}")    // 但是这里的名字必须和键名一样
    private String name2; // 注意成员变量的名称和配置文件中的数据的键的名称没有任何关系
    @Value("${person.age}")    // 但是这里的名字必须和键名一样
    private int age; // 这块的数据接受的类型可以是String也可以是int
    @Value("${address[0]}")    // 数组用中括号加索引
    private String address; // 这块的数据接受的类型可以是String也可以是int
    // 纯量直接引用就好 像上面的name一样

    // 会自动注入 著需要注入一个对象就可以了
    private final Environment env;

    public HelloController(Environment env) {
        this.env = env;
    }

    @RequestMapping("/env")
    public String getEnv(){
        return env.getProperty("person.name");
    }

    @RequestMapping("/name")
    public String getName(){
        return name;
    }

    @RequestMapping("/name2")
    public String getName2(){
        return name2;
    }

    @RequestMapping("/age")
    public int getAge(){   // 这里的数据类型要注意和返回的数据类型一致
        return age;
    }

//    @RequestMapping("/address")
//    public String getAddress(){
//        return address;
//    }


    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }

    @Autowired
    private Person person;

    @RequestMapping("/person/name")
    public String personName(){
        return person.getName();
    }
    @RequestMapping("/person/age")
    public int personAge(){
        return person.getAge();
    }
    @RequestMapping("/address")  // 目前还是有问题，所以先不要使用这方法
    public String address(){
        String[] address = person.getAddress();   // 获取不到address
        for(int i=0;i<address.length;i++){
            System.out.println(address[i]);
        }
        return "good";
    }
}
