package com.example.study.demo;
// 我们将在这里实现@ConfigurationProperties的实现
// 能够将这个对象中的属性自动注入到yaml中的对象对应的键的值上

// 注意 如果你要是想要使用getter setter自动生成 需要在xml中加上一个Lombok依赖

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 被spring识别 是一个Bean
@ConfigurationProperties(prefix = "person")  // 需要加上一个前缀来确认是指定的person对象
public class Person {
    private String name;
    private int age;  // 上面这两个属性名字必须与yaml中的键一致
    private String[] address;

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override // 为了打印方便
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
