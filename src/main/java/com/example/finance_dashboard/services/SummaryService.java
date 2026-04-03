package com.example.finance_dashboard.services;

import com.example.finance_dashboard.model.FinancialRecord;
import com.example.finance_dashboard.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    private final RecordRepository recordRepository;

    public SummaryService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public double getTotalIncome() {
        return recordRepository.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("income"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return recordRepository.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("expense"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }
}