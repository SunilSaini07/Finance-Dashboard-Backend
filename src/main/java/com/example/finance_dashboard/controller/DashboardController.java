package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.services.SummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/summary")
public class DashboardController {

    private final SummaryService summaryService;

    public DashboardController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping
    public Map<String, Double> getSummary(@RequestHeader("Role") String role) {

        if (!(role.equals("ADMIN") || role.equals("ANALYST"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Denied");
        }

        Map<String, Double> data = new HashMap<>();
        data.put("totalIncome", summaryService.getTotalIncome());
        data.put("totalExpense", summaryService.getTotalExpense());
        data.put("balance", summaryService.getBalance());

        return data;
    }
}