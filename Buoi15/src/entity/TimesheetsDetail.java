package entity;

public class TimesheetsDetail {
    private Factory factory;
    private int dayWork;

    public TimesheetsDetail(Factory factory, int dayWork) {
        this.factory = factory;
        this.dayWork = dayWork;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public int getDayWork() {
        return dayWork;
    }

    public void setDayWork(int dayWork) {
        this.dayWork = dayWork;
    }


}
