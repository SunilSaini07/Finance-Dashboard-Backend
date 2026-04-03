package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.model.FinancialRecord;
import com.example.finance_dashboard.services.RecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

//    @PostMapping
//    public FinancialRecord createRecord(@RequestBody FinancialRecord record) {
//        return recordService.createRecord(record);
//    }

    @PostMapping
    public FinancialRecord createRecord(
            @RequestHeader("Role") String role,
            @Valid @RequestBody FinancialRecord record) {

        if (!role.equalsIgnoreCase("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/type")
    public List<FinancialRecord> getByType(@RequestParam String type) {
        return recordService.getByType(type);
    }

    @GetMapping("/category")
    public List<FinancialRecord> getByCategory(@RequestParam String category) {
        return recordService.getByCategory(category);
    }

    @GetMapping("/date")
    public List<FinancialRecord> getByDate(
            @RequestParam String start,
            @RequestParam String end) {

        return recordService.getByDateRange(
                LocalDate.parse(start),
                LocalDate.parse(end)
        );
    }

//    @DeleteMapping("/{id}")
//    public void deleteRecord(@PathVariable Long id) {
//        recordService.deleteRecord(id);
//    }
    @DeleteMapping("/{id}")
    public void deleteRecord(
            @RequestHeader("Role") String role,
            @PathVariable Long id) {

        if (!role.equalsIgnoreCase("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        recordService.deleteRecord(id);
    }
}