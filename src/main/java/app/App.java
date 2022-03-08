/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import business.FinanceCalculator;
import data.FinanceBean;
import presentation.FinanceUserInterface;

/**
 *
 * @author jpcasati
 */
public class App {
    
    // Todas as classes que eu usarei no programa
    private FinanceBean financeBean;
    private FinanceCalculator financeCalculator;
    private FinanceUserInterface financeUserInterface;
    
    public void perform() {
        // Inicia a execução do programa propriamente dito, do início, 
        // que é a exibição do menu
        
        financeBean = new FinanceBean();
        financeCalculator = new FinanceCalculator(financeBean);
        financeUserInterface = new FinanceUserInterface(financeBean, financeCalculator);
        
        financeUserInterface.perform();
        
    }
    
    public static void main(String[] args) {
        new App().perform();
    }
    
}
