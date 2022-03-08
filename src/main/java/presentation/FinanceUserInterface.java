/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.FinanceCalculator;
import data.FinanceBean;
import java.util.Scanner;

/**
 *
 * @author jpcasati
 */
public class FinanceUserInterface {
    
    private final FinanceCalculator financeCalculator;
    private final FinanceBean financeBean;
    private final Scanner sc;

    public FinanceUserInterface(FinanceBean financeBean, FinanceCalculator financeCalculator) {
        this.financeBean = financeBean;
        this.financeCalculator = financeCalculator;
        sc = new Scanner(System.in);
    }

    public void perform() {
        char choice;

        do {
            
            System.out.println("Please, enter a char from A to D: ");
            System.out.println("(A) - Loan Calculator");
            System.out.println("(B) - Saving Goal Calculator");
            System.out.println("(C) - Future Value Calculator");
            System.out.println("(D) - Exit");
            
            choice = menu();
            switch (choice) {
                case 'A': { // Ask for loan info
                    requestLoanPaymentInfo();
                    financeCalculator.calculateLoanPayment();
                    displayLoanResult();
                } break;
                case 'B': { // Ask for Savings Goal info
                    requestSavingsGoalInfo();
                    financeCalculator.calculateSavingsGoal();
                    displaySavingsGoalResult();
                } break;
                case 'C': { // Ask for Futire Value info
                    requestFutureValueInfo();
                    financeCalculator.calculateFutureValue();
                    displayFutureValueResult();
                } break;
                case 'D': { // Program exit
                    System.out.println("GOOD BYE");
                } break;
                default: {
                    System.out.println("I should never see this");
                } break;
            }
        } while (choice != 'D');
    }

    // You will need to implement methods as found in MenuExample
    private char menu() {
        char choice = sc.next().charAt(0);

        return choice;
    }

    /* 
    The following three methods will ask the user for the three values 
    necessary for the calculation and store the user input in the FinanceBean 
     */
    private void requestLoanPaymentInfo() {
        
        System.out.println("Enter the Total Amont of the Loan ($): ");
        double res = sc.nextDouble();
        financeBean.setPv(res);

        System.out.println("Enter the Annual Interest Rate (%): ");
        res = sc.nextDouble();
        financeBean.setRate(res);

        System.out.println("Enter the Number of Months ");
        res = sc.nextDouble();
        financeBean.setN(res);

    }

    private void requestSavingsGoalInfo() {

    }

    private void requestFutureValueInfo() {

    }

    /*
    The following three methods will display the input and result of each 
    calculation as found in the FinanceBean
     */
    private void displayLoanResult() {
        System.out.println("RESULT: " + financeBean.getPmt());
    }

    private void displaySavingsGoalResult() {

    }

    private void displayFutureValueResult() {

    }
    
}
