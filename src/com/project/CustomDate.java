package com.project;

public class CustomDate {
    private int day;
    private int month;
    private int year;

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isBefore(CustomDate another){
        return (year > another.year ||
                (year == another.year && month > another.month) ||
                (year == another.year && month == another.month && day > another.day) );
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void nextDay(){
        day += 1;
        if(this.getDay() == 32){
            this.month += 1;
            this.day = 1;
        }
        if(this.month == 13){
            this.month = 1;
            this.year += 1;
        }
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
