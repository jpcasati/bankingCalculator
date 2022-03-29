/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;
import business.FinanceCalculator;
import data.FinanceBean;
import java.util.Scanner;
/**
 *
 * @author Carlos
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
        
        //char choice = choice.toUpperCase();
            
        
        do {
            
            System.out.println("Please, choose your Operation): ");
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
                
                case 'C': { // Ask for Future Value info
                    requestFutureValueInfo();
                    financeCalculator.calculateFutureValue();
                    displayFutureValueResult();
                } break;
                
                case 'D': { // Program exit
                    System.out.println("Thank You For Using our System");
                    System.out.println("********** GOOD BYE **********");
                            
                    
                } break;
                default: {
                    System.out.println("Incorrect Input: ");
                } break;
            }
        } while (choice != 'D');
    }

       private char menu() {
        
       char choice = sc.next().toUpperCase().charAt(0);  // checar
        
           return choice;
       
    }

    /* 
    The following three methods will ask the user for the three values 
    necessary for the calculation and store the user input in the FinanceBean 
     */
    private void requestLoanPaymentInfo() {
        
        System.out.println("Enter the Total Amount of the Loan ($): ");
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
        
      System.out.println("Enter the Total Amont Desired ($): ");
        double res = sc.nextDouble();
        financeBean.setFv(res);

        System.out.println("Enter the Annual Interest Rate (%): ");
        res = sc.nextDouble();
        financeBean.setRate(res);

        System.out.println("Enter the Number of Years to Reach your Goal ");
        res = sc.nextDouble();
        financeBean.setN(res);  
        

    }

    private void requestFutureValueInfo() {
        
        
     System.out.println("Enter the Amount PER MONTH You Want to Invest($): ");
        double res = sc.nextDouble();
        financeBean.setPmt(res);

        System.out.println("Enter the Annual Interest Rate Projected (%): ");
        res = sc.nextDouble();
        financeBean.setRate(res);

        System.out.println("Enter the Number of Years for Your Investment ");
        res = sc.nextDouble();
        financeBean.setN(res);  
            
        

    }

    /*
    The following three methods will display the input and result of each 
    calculation as found in the FinanceBean
     */
    private void displayLoanResult() {
        //System.out.println("RESULT: " + financeBean.getPmt());
        System.out.printf("For This Loan at The Conditions Informed, We Project a Payment of $%.2f / Month.\n\n", financeBean.getPmt());
        System.out.println("Please, choose other Operation or Exit):") ;
    }

    private void displaySavingsGoalResult() {
    //System.out.println("RESULT: " + financeBean.getPmt());    
        System.out.printf("At the Conditions Informed, We Project You Will be Reaching the Amount Desired Investing $%.2f  / Month.\n\n", financeBean.getPmt()); 
        
        System.out.println("Please, choose other Operation or Exit):") ;
    }

    private void displayFutureValueResult() {
    //System.out.println("RESULT: " + Math.round(financeBean.getFv()));
    System.out.printf("At the Conditions Informed, We Project You May be Investing $ %.2f / Month to Reach the Amont of $%.2f \n\n",financeBean.getPmt(), financeBean.getFv());
        
    }
    
    
    
}