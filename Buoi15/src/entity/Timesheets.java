package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timesheets implements Serializable {
    private Staff staff;
    private List<TimesheetsDetail> timesheetsDetails;
    private int totalDayWork;
    private int totalworkFactor;

    public Timesheets(Staff staff, List<TimesheetsDetail> timesheetsDetails) {
        this.staff = staff;
        this.timesheetsDetails = timesheetsDetails;

        int temp = 0;
        int total = 0;
        for (int i = 0; i < timesheetsDetails.size(); i++) {
            temp += timesheetsDetails.get(i).getDayWork();
            total +=timesheetsDetails.get(i).getFactory().getWorkFactor();
        }
        this.totalDayWork = temp;
        this.totalworkFactor = total;
    }

    public int getTotalworkFactor() {
        return totalworkFactor;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<TimesheetsDetail> getTimesheetsDetails() {
        return timesheetsDetails;
    }

    public void setTimesheetsDetails(List<TimesheetsDetail> timesheetsDetails) {
        this.timesheetsDetails = timesheetsDetails;
    }

    public int getTotalDayWork() {
        return totalDayWork;
    }

    public void setTotalDayWork(int totalDayWork) {
        this.totalDayWork = totalDayWork;
    }

    @Override
    public String toString() {
        return "Timesheets{" +
                "staff=" + staff +
                ", timesheetsDetails=" + timesheetsDetails +
                ", totalDayWork=" + totalDayWork +
                '}';
    }
}
