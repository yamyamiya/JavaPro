package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student1 = (Student) context.getBean("student");
		Student student2 = (Student) context.getBean("student");
		student1.setAge(22);
		student1.setName("Alex");
		System.out.println(student2.getName());
		System.out.println(student2.getAge());

	}

}
