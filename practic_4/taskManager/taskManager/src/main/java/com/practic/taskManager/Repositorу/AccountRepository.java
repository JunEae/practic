package com.practic.taskManager.Repositorу;

import com.practic.taskManager.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

