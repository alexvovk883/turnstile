package com.project.validity;

import com.project.CustomDate;
import com.project.Turnstile;
import com.project.exceptions.NotEnoughDays;

public class Validity {
    private CustomDate payDay;
    private int daysLeft;

    public Validity(CustomDate payDay) {
        this.payDay = payDay;
        this.daysLeft = 31 - Turnstile.getInstance().getLocalDate().getDay();
    }

    public Validity() {
        this.daysLeft = 10;
        payDay = new CustomDate(Turnstile.getInstance().getLocalDate().getDay(), Turnstile.getInstance().getLocalDate().getMonth(), Turnstile.getInstance().getLocalDate().getYear());
    }

    public void checkValidity() throws NotEnoughDays {
        if(daysLeft < 0){
            throw new NotEnoughDays("NAN");
        }
    }

    public void minusDay(){
        this.daysLeft -= 1;
    }

    @Override
    public String toString() {
        return "Validity{" +
                "payDay=" + payDay +
                ", daysLeft=" + daysLeft +
                '}';
    }
}
