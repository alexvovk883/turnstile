package com.project;

import com.project.exceptions.NotEnoughMoney;
import com.project.exceptions.NotEnoughTrips;
import com.project.pass.Pass;
import com.project.pass.SchoolPass;
import com.project.pass.StandardPass;
import com.project.pass.StudentPass;

import java.util.ArrayList;

public class Turnstile {
    private final ArrayList<Pass> passes;
    private final CustomDate localDate;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private static Turnstile instance;

    private Turnstile(CustomDate localDate) {
        this.localDate = localDate;
        passes = new ArrayList<>();
    }

    public static Turnstile getInstance(CustomDate localDate){
        if(instance == null)
            instance = new Turnstile(localDate);
        return instance;
    }

    public static Turnstile getInstance(){
        if(instance == null)
            throw new IllegalArgumentException();
        return instance;
    }

    public void takePayment(Pass pass){
        System.out.println("Turnstile taking payment from " + pass.getClass().getSimpleName() + " with ID" + pass.getId() + "...");
        try {
            pass.execute();
            System.out.println("ID" + pass.getId() + " passage is allowed.");
        } catch (NotEnoughTrips | NotEnoughMoney e) {
            System.out.println(e.getMessage());
        }
    }

    public CustomDate getLocalDate() {
        return localDate;
    }

    public void nextDay(){
        this.localDate.nextDay();
        System.out.println("Today is: " + localDate.getDay() + ". " + localDate.getMonth() + ". " + localDate.getYear());
        for(Pass p : passes){
            p.minusDay();
        }
    }

    public void printByCategories(){
        System.out.println("\n-----Standard category-----");
        passes.stream().filter(x -> x instanceof StandardPass).forEach(System.out::println);
        System.out.println("\n-----School category-----");
        passes.stream().filter(x -> x instanceof SchoolPass).forEach(System.out::println);
        System.out.println("\n-----Student category-----");
        passes.stream().filter(x -> x instanceof StudentPass).forEach(System.out::println);
    }

    public void addPass(Pass pass){
        this.passes.add(pass);
    }

    public void printAllPasses(){
        passes.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Turnstile{" +
                "localDate=" + localDate +
                ", price=" + price +
                '}';
    }
}
