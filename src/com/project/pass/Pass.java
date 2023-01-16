package com.project.pass;

import com.project.exceptions.NotEnoughMoney;
import com.project.exceptions.NotEnoughTrips;

public class Pass {
    private int id;

    public Pass() {
        id = (int) (Math.random() * 1000000);
    }

    public int getId() {
        return id;
    }

    public void execute() throws NotEnoughTrips, NotEnoughMoney {

    }


    public void minusDay(){

    }

    @Override
    public String toString() {
        return "Pass{" +
                "id=" + id +
                '}';
    }

    public void addMoney(double i) {
    }
}
