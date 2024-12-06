package com.aop.aopdemo;

import com.aop.aopdemo.dto.Account;
import com.aop.aopdemo.repo.AccountRepository;
import com.aop.aopdemo.repo.MemberShipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository , MemberShipRepository memberShipRepository) {

		return runner ->{

			//demoTheBefore(accountRepository , memberShipRepository);
			demoTheAfterReturnAdvice(accountRepository);

		};
	}


	private void demoTheBefore(AccountRepository accountRepository , MemberShipRepository memberShipRepository) {

		Account myAccount = new Account();
		accountRepository.addAccount(myAccount , true);
		accountRepository.doWork();


		accountRepository.setName("foobar");
		accountRepository.setServiceCode("platinum");

		String name = accountRepository.getName();
		String code = accountRepository.getServiceCode();

		//memberShipRepository.addAccount();

		memberShipRepository.addSillyMember();
		memberShipRepository.suspendMembershipRepo();
	}

	private void demoTheAfterReturnAdvice(AccountRepository accountRepository ) {
		List<Account> theAccounts = accountRepository.findAccounts();
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice , 성공했으면 생성되는 AOP");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

	}
}
