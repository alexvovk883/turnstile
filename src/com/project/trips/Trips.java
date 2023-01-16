package com.project.trips;

import com.project.exceptions.NotEnoughTrips;

public class Trips {
    private int trips;

    public Trips(int trips) {
        if(trips == 5 || trips == 10)
            this.trips = trips;
        else throw new IllegalArgumentException("Uncorrected trips quantity");
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    public boolean makeTrip() throws NotEnoughTrips {
        if(trips > 1) {
            trips -= 1;
            return true;
        }
        throw new NotEnoughTrips("NAN");
    }


    @Override
    public String toString() {
        return "Trips{" +
                "trips=" + trips +
                '}';
    }
}
