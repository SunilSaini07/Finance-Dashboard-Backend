package com.example.finance_dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance_dashboard.model.FinancialRecord;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {
    List<FinancialRecord> findByType(String type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}
