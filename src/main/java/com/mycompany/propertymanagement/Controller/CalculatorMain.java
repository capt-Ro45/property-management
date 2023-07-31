package com.mycompany.propertymanagement.Controller;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(4.5, 6.3);
        System.out.println(result);
    }

}
