package com.centum.userservice.VO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySavings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthlysavingsId;
    private String month;

    @ElementCollection
    private List<Double> incomes;

    @ManyToOne
    @JoinColumn(name = "monthlyexpenses_id")
    private MonthlyExpenses monthlyexpenses;


    @Embedded
    private Totalincome toatalincome;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class Totalincome {
        private double incentives;
        private double bonus;
        private double income1;
        private double income2;
    }
    public double calculateTotal() {
        return toatalincome.incentives + toatalincome.bonus + toatalincome.income1 + toatalincome.income2; //To change body of generated methods, choose Tools | Templates.
    }
    public double calculateMonthlyNet() {
        return incomes.stream().mapToDouble(Double::doubleValue).sum();
    }

}
