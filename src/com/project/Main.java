package com.project;

import com.project.pass.Pass;
import com.project.pass.SchoolPass;
import com.project.pass.StandardPass;
import com.project.pass.StudentPass;
import com.project.trips.Trips;
import com.project.validity.Validity;

public class Main {
    public static void main(String[] args) {
        Turnstile turnstile = Turnstile.getInstance(new CustomDate(23,12, 2022));
        turnstile.setPrice(15.0);
        System.out.println("INFO about turnstile");
        System.out.println(turnstile);
        System.out.println("---------------------------------------------\n");

        Pass schoolPass = new SchoolPass(new Trips(5), new Validity());
        Pass studentPass = new StudentPass(new Trips(10), new Validity(new CustomDate(8, 12, 22)));
        Pass standardPass = new StandardPass();

        System.out.println("INFO about passes in turnstile database:");
        turnstile.printAllPasses();
        System.out.println("---------------------------------------------------\n");

        System.out.println("INFO about passes in turnstile by categorise:");
        turnstile.printByCategories();
        System.out.println("---------------------------------------------------\n");

        turnstile.takePayment(schoolPass);
        System.out.println("---------------------------------------------------\n");

        System.out.println("Turnstile change date: ");
        turnstile.nextDay();
        System.out.println("---------------------------------------------------\n");

        System.out.println("INFO about passes in turnstile database:");
        turnstile.printAllPasses();
        System.out.println("---------------------------------------------------\n");

        turnstile.takePayment(studentPass);
        System.out.println("---------------------------------------------------\n");

        System.out.println("Turnstile change date: ");
        turnstile.nextDay();
        System.out.println("---------------------------------------------------\n");

        System.out.println("INFO about passes in turnstile database:");
        turnstile.printAllPasses();
        System.out.println("---------------------------------------------------\n");


        turnstile.takePayment(standardPass);
        System.out.println("---------------------------------------------------\n");

        standardPass.addMoney(200);
        System.out.println("---------------------------------------------------\n");

        turnstile.takePayment(standardPass);
        System.out.println("---------------------------------------------------\n");

        System.out.println("INFO about passes in turnstile database by categories:");
        turnstile.printByCategories();
        System.out.println("---------------------------------------------------\n");

        Pass standartPass1 = new StandardPass();

        System.out.println("INFO about passes in turnstile database by categories after creating one more standard pass:");
        turnstile.printByCategories();
        System.out.println("---------------------------------------------------\n");


        System.out.println("Changing date on turnstile: ");
        for(int i = 0; i < 20; i++){
            turnstile.nextDay();
        }
        System.out.println("---------------------------------------------------\n");


        System.out.println("INFO about passes in turnstile database by categories:");
        turnstile.printByCategories();
        System.out.println("---------------------------------------------------\n");

        turnstile.takePayment(studentPass);
        System.out.println("---------------------------------------------------\n");

        turnstile.takePayment(schoolPass);
    }
}
