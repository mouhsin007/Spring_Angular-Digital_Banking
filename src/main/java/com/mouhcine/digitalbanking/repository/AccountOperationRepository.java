package com.mouhcine.digitalbanking.repository;

import com.mouhcine.digitalbanking.entities.AccountOperation;
import com.mouhcine.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
