package mypoint;
public class MyPoint{
    double x;
    double y;

    public MyPoint() {
    }
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public MyPoint(MyPoint p) {
        p.getX();
        p.getY();
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double distance(MyPoint SecondPoint) {
        double a = Math.pow(this.x - SecondPoint.x, 2);
        double b = Math.pow(this.y - SecondPoint.y, 2);
        return Math.sqrt(a + b);
    }
    public double distances(MyPoint p1,MyPoint p2) {
        double a = Math.pow(p1.getX() - p2.getX(), 2);
        double b = Math.pow(p1.getY() - p2.getY(), 2);
        return Math.sqrt(a + b);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}