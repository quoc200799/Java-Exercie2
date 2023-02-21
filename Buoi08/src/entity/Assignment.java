package entity;

import java.util.Arrays;

public class Assignment {
    private Driver driver;
    private Tour[] tour;

    @Override
    public String toString() {
        return "Assignment{" +
                "driver=" + driver +
                ", tour=" + Arrays.toString(tour) +
                '}';
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Tour[] getTour() {
        return tour;
    }

    public void setTour(Tour[] tour) {
        this.tour = tour;
    }

    public Assignment(Driver driver, Tour[] tour) {
        this.driver = driver;
        this.tour = tour;
    }

    public double totalPoint() {
        double total = 0;
        for (Tour tours : tour) {
            total += tour.length;
        }
        return total;
    }

    public Double totalATour() {
        double total = 0;
        for (int i = 0; i < getTour().length; i++) {
            if (getTour()[i] != null) {
                total += getTour()[i].getTurn() * getTour()[i].getBuses().getDistance();
            }
        }
        return total;
    }
}
