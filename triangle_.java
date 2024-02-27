public class triangle_{
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
        Triangle triangle2 = new Triangle(1.0, 1.0, 2.0);
        try {
            System.out.println(triangle1.area());
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        try {
            System.out.println(triangle2.area());
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}

class Triangle {
    private double a,b,c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area(){
        if(a<=0||b<=0||c<=0||(a+b)<=c||(a+c)<=b||(b+c)<=a) {
            throw new NotTriangle("非三角形");
        }
        else{
               double p=(a+b+c)/2;
               return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }

    }


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
class NotTriangle extends RuntimeException{
    public NotTriangle(String message) {
        super(message);
    }
}

