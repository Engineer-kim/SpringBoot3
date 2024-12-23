package com.aop.aopdemo;

import com.aop.aopdemo.dto.Account;
import com.aop.aopdemo.repo.AccountRepository;
import com.aop.aopdemo.repo.MemberShipRepository;
import com.aop.aopdemo.service.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	private final AccountRepository accountRepository;

	public AopdemoApplication(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository accountRepository , MemberShipRepository memberShipRepository, TestService testService) {

		return runner ->{

			//demoTheBefore(accountRepository , memberShipRepository);
			//demoTheAfterReturnAdvice(accountRepository);
			demoTheAfterThrowingAdvice(accountRepository);
			demoTheAfterAdvice(accountRepository);
			demoTheAroundAdvice(testService);
		};
	}
	private void demoTheAroundAdvice(TestService testService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = testService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}


	private void demoTheAfterAdvice(AccountRepository accountRepository) {

		List<Account> theAccounts = null;
		try {
			boolean boolValue = false;
			theAccounts = accountRepository.findAccounts(boolValue);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountRepository accountRepository) {
		List<Account> theAccounts = null;
		try {
			boolean booleanValue = true;
			theAccounts = accountRepository.findAccounts(booleanValue);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
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
