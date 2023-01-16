package com.project.pass;

import com.project.Turnstile;
import com.project.exceptions.NotEnoughMoney;

public class StandardPass extends Pass{
    private double balance;

    public StandardPass() {
        this.balance = 0;

        Turnstile.getInstance().addPass(this);
    }

    @Override
    public void addMoney(double sum){
        this.balance += sum;
        System.out.println("ID" + this.getId() + " replenished. New balance is: " + balance);
    }

    public void execute() throws NotEnoughMoney {
        if(balance >= Turnstile.getInstance().getPrice()){
            this.balance -= Turnstile.getInstance().getPrice();
            System.out.println("ID" + this.getId() + " passage is allowed.");
        }
        else throw new NotEnoughMoney("ERROR! ID" + this.getId() + " - not enough money.");
    }

    @Override
    public String toString() {
        return "StandardPass{" +
                "id=" + super.getId() +
                ", balance=" + balance +
                '}';
    }
}
