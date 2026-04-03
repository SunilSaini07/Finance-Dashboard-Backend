package com.example.finance_dashboard.services;

import com.example.finance_dashboard.model.FinancialRecord;
import com.example.finance_dashboard.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public FinancialRecord createRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<FinancialRecord> getByType(String type) {
        return recordRepository.findByType(type);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return recordRepository.findByCategory(category);
    }

    public List<FinancialRecord> getByDateRange(LocalDate start, LocalDate end) {
        return recordRepository.findByDateBetween(start, end);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}