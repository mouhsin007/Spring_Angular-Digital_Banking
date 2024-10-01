package com.mouhcine.digitalbanking.services;

import com.mouhcine.digitalbanking.entities.*;
import com.mouhcine.digitalbanking.exceptions.BalanceNotSufficientException;
import com.mouhcine.digitalbanking.exceptions.BankAccountNotFoundException;
import com.mouhcine.digitalbanking.exceptions.CustomerNotFoundException;
import com.mouhcine.digitalbanking.repository.AccountOperationRepository;
import com.mouhcine.digitalbanking.repository.BankAccountRepository;
import com.mouhcine.digitalbanking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{


    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;
    private AccountOperationRepository accountOperationRepository;

    @Override
    public Customer saveCustomer(Customer customerDTO) {
        return null;
    }

    @Override
    public CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public List<Customer> listCustomers() {
        return List.of();
    }

    @Override
    public BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException {

    }

    @Override
    public void credit(String accountId, double amount, String description) throws BankAccountNotFoundException {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException {

    }

    @Override
    public List<BankAccount> bankAccountList() {
        return List.of();
    }

    @Override
    public Customer getCustomer(Long customerId) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }

    @Override
    public List<AccountOperation> accountHistory(String accountId) {
        return List.of();
    }

    @Override
    public BankAccount getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException {
        return null;
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        return List.of();
    }
}
