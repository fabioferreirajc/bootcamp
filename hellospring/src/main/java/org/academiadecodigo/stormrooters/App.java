package org.academiadecodigo.stormrooters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context= new ClassPathXmlApplicationContext("/spring-config.xml");

        HelloWorld helloWorld = context.getBean("hello", HelloWorld.class);
        helloWorld.sayHello();

        HelloWorld helloWorld2 = context.getBean("world", HelloWorld.class);
        helloWorld2.sayHello();


    }
}
