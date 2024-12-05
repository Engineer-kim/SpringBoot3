package com.aop.aopdemo;

import com.aop.aopdemo.repo.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository) {

		return runner ->{

			demoTheBefore(accountRepository);


		};
	}


	private void demoTheBefore(AccountRepository accountRepository) {
		accountRepository.addAccount();
	}
}
