package com.mouhcine.digitalbanking.repository;

import com.mouhcine.digitalbanking.entities.BankAccount;
import com.mouhcine.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
