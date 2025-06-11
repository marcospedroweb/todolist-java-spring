package br.com.marcospedroweb.todolist; //Tudo fica dentro de um package

import org.springframework.boot.SpringApplication; //São classes, que pode reutilizar nas classes
import org.springframework.boot.autoconfigure.SpringBootApplication;//São classes, que pode reutilizar nas classes

@SpringBootApplication // Anotation - Ela executa alguma coisa, é uma função
public class TodolistApplication {

	public static void main(String[] args) { // Método main, principal
		SpringApplication.run(TodolistApplication.class, args);
	}

}
