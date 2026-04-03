package com.example.finance_dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance_dashboard.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
