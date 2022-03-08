/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.FinanceBean;

/**
 *
 * @author jpcasati
 */
public class FinanceCalculator {
    
    private final FinanceBean financeBean;

    public FinanceCalculator(FinanceBean financeBean) {
        this.financeBean = financeBean;
    }


    public void calculateDemo() {
        double result = financeBean.getRate() * financeBean.getPmt();
        financeBean.setPv(result);
    }

    public void calculateLoanPayment() {
        
        financeBean.setRate(financeBean.getRate()/(12*100));
        
        double result = financeBean.getPv() * (financeBean.getRate() / 
                (1 - Math.pow((1 + financeBean.getRate()), -financeBean.getN())));
        
        financeBean.setPmt(result);
        
    }

    public void calculateSavingsGoal() {

    }

    public void calculateFutureValue() {

    }
    
}
