package com.mouhcine.digitalbanking.services;

import com.mouhcine.digitalbanking.entities.*;
import com.mouhcine.digitalbanking.exceptions.BalanceNotSufficientException;
import com.mouhcine.digitalbanking.exceptions.BankAccountNotFoundException;
import com.mouhcine.digitalbanking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customerDTO);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();

    Customer getCustomer(Long customerId) throws CustomerNotFoundException;

    Customer updateCustomer(Customer customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperation> accountHistory(String accountId);

    BankAccount getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<Customer> searchCustomers(String keyword);
}
