import static java.lang.Math.PI;

public class FirstProblem {
    public static void main(String[] args) {
        Perarea rectangle1 = new rectangle(10, 5);
        Perarea circle1 = new circle(5);
        System.out.println("长方形的面积为："+rectangle1.get_area()+" 周长为："+rectangle1.get_perimeter());
        System.out.println("圆形的面积为："+circle1.get_area()+" 周长为："+circle1.get_perimeter());
    }
}
interface Perarea{
    double get_area();
    double get_perimeter();
}
class rectangle implements Perarea{

    private double longSide;
    private double shortSide;

    @Override
    public double get_area() {
        return longSide*shortSide;
    }

    @Override
    public double get_perimeter() {
        return 2*(shortSide+longSide);
    }
    public rectangle(double longSide, double shortSide) {
        this.longSide = longSide;
        this.shortSide = shortSide;
    }
}
class circle implements Perarea{
    private double length_;

    public circle(double length_) {
        this.length_ = length_;
    }

    @Override
    public double get_area() {
        return length_*length_*PI;
    }

    @Override
    public double get_perimeter() {
        return 2*PI*length_;
    }
}

