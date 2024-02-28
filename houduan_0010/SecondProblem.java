public class SecondProblem{
    public static void main(String[] args) {
        Plainrect plainrect = new Plainrect(10, 20, 10, 10);
        System.out.println("矩形的面积为"+plainrect.area()+" 周长为"+plainrect.perimeter());
        System.out.println("(25.5,13)是否在矩形中："+plainrect.isInside(25.5,13));
    }
}
class Rect{
    private double width = 10;
    private double height = 10;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public Rect()
    {

    }
    public double area(){
        return width*height;
    }
    public double perimeter(){
        return 2*(width+height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
class Plainrect extends Rect{
    private double startX;
    private double startY;

    public Plainrect(double width, double height, double startX, double startY) {
        super(width, height);
        this.startX = startX;
        this.startY = startY;
    }
    public Plainrect(){
        this.startX=0;
        this.startY=0;
    }
    public boolean isInside(double x,double y){
        if(x >= startX && x <= (startX+getWidth()) &&
                y < startY && y >= (startY-getHeight())){
            return true;
        }
        else{
            return false;
        }
    }
}