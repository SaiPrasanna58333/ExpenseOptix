package com.centum.userservice.VO;

import com.centum.userservice.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MonthlyExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthlyexpensesId;

    private String month;

    @Embedded
    private BasicExpenses basicExpenses;

    @Embedded
    private FinanceExpenses financeExpenses;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "monthlysavings_id")
    private MonthlySavings monthlysavings;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table
    public class BasicExpenses {

        private double rent;
        private double mortgage;
        private double electricityBill;
        private double Waterbill;
        private double Pay_for_gas;
        private double Satellite_Cable_Internet;
        private double PhonelandlineorCell;
        private double Fuelforvehicles;
        private double VehicleServicingCharges;
        private double Groceries;
        private double Feast;
        private double StuffforHouseholdPersonal;
        private double Care;
        private double ClothingandLaundry;
        private double Medicalbills;
        private double Entertainment;
        private double Hobbies;
        private double Memberships;
        private double Pets;
        private double Gifts_Donations;
        private double OtherInsurance;
        private double TravelCharges;
        private double MoneyPutintoSavings;
        private double Other;

        public double calculateTotal() {
            return rent + mortgage + electricityBill + Waterbill + Pay_for_gas + Satellite_Cable_Internet + PhonelandlineorCell + Fuelforvehicles +
                    VehicleServicingCharges + Groceries + Feast + StuffforHouseholdPersonal + Care + ClothingandLaundry + Medicalbills + Entertainment +
                    Hobbies + Memberships + Pets + Gifts_Donations + OtherInsurance + TravelCharges + MoneyPutintoSavings + Other;  //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table
    public class FinanceExpenses {

        private double vehiclesInsurance;
        private double homeLoan;
        private double creditCard;
        private double VehiclesLoan;
        private double Additional;

        public double calculateTotal() {
            return vehiclesInsurance + homeLoan + creditCard + VehiclesLoan + Additional;  //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Transient
    private double expenditure;



    // Calculate total expenditure

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateTotalExpenditure() {
        if (basicExpenses != null && financeExpenses != null) {
            expenditure = basicExpenses.calculateTotal() + financeExpenses.calculateTotal();
        } else {
            expenditure = 0.0;
        }

    }
}