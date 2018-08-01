package org.academiadecodigo.stormrooters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context= new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");

        HelloWorld helloWorld = context.getBean("hello", HelloWorld.class);
        HelloWorld helloWorld1 = context.getBean("hello", HelloWorld.class);
        helloWorld.sayHello();
        helloWorld.sayHello();
        System.out.println(helloWorld);
        System.out.println(helloWorld1);



        HelloWorld helloWorld2 = context.getBean("world", HelloWorld.class);
        helloWorld2.sayHello();


    }
}
