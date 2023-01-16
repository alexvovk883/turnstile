package com.project.pass;

import com.project.Turnstile;
import com.project.exceptions.NotEnoughDays;
import com.project.exceptions.NotEnoughTrips;
import com.project.trips.Trips;
import com.project.validity.Validity;

public class StudentPass extends Pass{
    private Trips trips;
    private Validity validity;

    public StudentPass( Trips trips, Validity validity) {
        this.trips = trips;
        this.validity = validity;
        Turnstile.getInstance().addPass(this);
    }

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    @Override
    public void execute() throws NotEnoughTrips {
        try {
            trips.makeTrip();
            validity.checkValidity();
        }catch (NotEnoughTrips e){
            throw new NotEnoughTrips("ERROR! ID" + this.getId() + " - not enough trips.");
        }
        catch (NotEnoughDays e){
            throw new NotEnoughTrips("ERROR! ID" + this.getId() + " - not enough days.");
        }
    }

    @Override
    public void minusDay() {
        this.validity.minusDay();
    }

    @Override
    public String toString() {
        return "StudentPass{" +
                "id=" + super.getId() +
                ", trips=" + trips +
                ", validity=" + validity +
                '}';
    }
}
