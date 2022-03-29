/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.FinanceBean;

/**
 *
 * @author Carlos
 */
public class FinanceCalculator {
    
    private final FinanceBean financeBean;

    public FinanceCalculator(FinanceBean financeBean) {
        this.financeBean = financeBean;
    }


//    public void calculateDemo() {
//        double result = financeBean.getRate() * financeBean.getPmt();
//        financeBean.setPv(result);
//    }

    public void calculateLoanPayment() {
        
        financeBean.setRate(financeBean.getRate()/(12*100));
        
        double result = financeBean.getPv() * (financeBean.getRate() / 
                (1 - Math.pow((1 + financeBean.getRate()), -financeBean.getN())));
        
        financeBean.setPmt(result);
        
    }

    public void calculateSavingsGoal() {
        
     financeBean.setRate(financeBean.getRate()/(12*100)); // Converts interest rate from year to month
     financeBean.setN(financeBean.getN()*12); // Converts years to months
     
     //c4 = c1  / ((1+c2) * ((Math.pow((1+c2),c3)-1)/c2));
      
     //double result = financeBean.getFv()  * (financeBean.getRate()) / 
            // ((1 -(Math.pow(1+financeBean.getRate(),financeBean.getN()))));
     
     //double result = (financeBean.getFv()*financeBean.getRate()) / ((1 - Math.pow((1 + financeBean.getRate()), financeBean.getN())));
       double result = (financeBean.getFv() * financeBean.getRate()) / ((1 - Math.pow((1 + financeBean.getRate()), financeBean.getN())));
             
            
     
     
     //financeBean.setPmt(result);
     financeBean.setPmt(Math.abs(result));

    }

    public void calculateFutureValue() {
        
        financeBean.setRate(financeBean.getRate()/(12*100));
        financeBean.setN(financeBean.getN()*12);
        
         
          //double result = financeBean.getPmt() * (((1-(Math.pow(1+financeBean.getRate(),financeBean.getN()))))) / financeBean.getRate(); 
         double result = financeBean.getPmt() * ((1 - Math.pow((1 + financeBean.getRate()),financeBean.getN()))) / financeBean.getRate(); 
          
           //financeBean.setFv(result);
          financeBean.setFv(Math.abs(result));
    }
    
}