package com.example.finance_dashboard.model;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double amount;

    @NotBlank
    private String type;

    @NotBlank
    private String category;

    private LocalDate date;

    @NotNull
    private String notes;
}
