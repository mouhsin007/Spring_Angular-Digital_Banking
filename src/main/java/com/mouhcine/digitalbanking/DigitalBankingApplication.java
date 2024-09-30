package com.mouhcine.digitalbanking;

import com.mouhcine.digitalbanking.entities.AccountOperation;
import com.mouhcine.digitalbanking.entities.CurrentAccount;
import com.mouhcine.digitalbanking.entities.Customer;
import com.mouhcine.digitalbanking.entities.SavingAccount;
import com.mouhcine.digitalbanking.enums.AccountStatus;
import com.mouhcine.digitalbanking.enums.OperationType;
import com.mouhcine.digitalbanking.repository.AccountOperationRepository;
import com.mouhcine.digitalbanking.repository.BankAccountRepository;
import com.mouhcine.digitalbanking.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository CustomerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("hassan","yassin","aicha").forEach(name->{
                Customer customer =new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust->{
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCustomer(cust);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

            });
            customerRepository.findAll().forEach(cust->{
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCustomer(cust);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);

            });
            bankAccountRepository.findAll().forEach(acc->{
                for(int i=0;i<20;i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType(Math.random()>0.5? OperationType.DEBIT:OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }
            });

        };
    }
}
