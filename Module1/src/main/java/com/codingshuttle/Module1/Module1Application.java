package com.codingshuttle.Module1;

import com.codingshuttle.Module1.Cake.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {
	private CakeBaker cakeBaker;

	public Module1Application(CakeBaker cakeBaker) {
		this.cakeBaker = cakeBaker;
	}

	public static void main(String[] args)	 {
		SpringApplication.run(Module1Application.class, args);
	}

	public void run(String... args) throws Exception {
		cakeBaker.bakecake();
	}

}
