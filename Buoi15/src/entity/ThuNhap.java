package entity;

public class ThuNhap {
    private String name;
    private double thunhap;

    public ThuNhap(String name, double thunhap) {
        this.name = name;
        this.thunhap = thunhap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getThunhap() {
        return thunhap;
    }

    public void setThunhap(double thunhap) {
        this.thunhap = thunhap;
    }

    @Override
    public String toString() {
        return "ThuNhap{" +
                "name='" + name + '\'' +
                ", thunhap=" + thunhap +
                '}';
    }
}
