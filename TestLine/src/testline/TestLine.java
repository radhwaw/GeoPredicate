package testline;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import sun.security.acl.OwnerImpl;


/**
 *
 * @author Radhitya
 */
public class TestLine extends Frame
{
    //Line2D line1 = new Line2D.Double(0, 0, 200, 200);
    //Line2D line2 = new Line2D.Double(70, 80, 100, 200);
    //Line2D line3 = new Line2D.Double(100, 150, 150, 150);
    //Line2D line3 = new Line2D.Double(378, 77, 50, 180);
    double x1=50;
    double y1=50;
    double x2=200;
    double y2=100;
    
    double xp=210;
    double yp=150;
    Line2D line3 = new Line2D.Double(x1, y1, x2, y2);
    Point2D point = new Point2D.Double(xp, yp);
    
    Stroke drawingStroke = new BasicStroke(2);

    public void paint(Graphics g)
    {
        Graphics2D graph = (Graphics2D)g;
        graph.setStroke(drawingStroke);
        graph.setPaint(Color.green);
        //graph.draw(line1);
        //graph.setPaint(Color.red);
        //graph.draw(line2);
        //graph.setPaint(Color.yellow);
        graph.draw(line3);
        graph.setPaint(Color.red);
        graph.drawOval((int)xp, (int)yp, 1, 1);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Frame frame = new TestLine();
        frame.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
        System.exit(0);}});
        frame.setSize(300, 250);
        frame.setVisible(true);
        frame.setTitle("Line Testing");
        
        TestLine tl = new TestLine();
        tl.test(82, 111);
        double m=tl.getM(100, 100, 200, 400);
        double x=tl.getX(new Point2D.Double(100, 100), m, 200);
        double y=tl.getY(new Point2D.Double(100, 100), m, 400/3);
        
        System.out.println("m="+m);
        System.out.println("x="+x);
        System.out.println("y="+y);
        //tl.orientationY(new Point2D.Double(82, 111),new Line2D.Double(378, 77, 50, 180));
        tl.orientationY();
    }
    
    public double getM(double x1, double y1, double x2, double y2)
    {
        return (y2-y1)/(x2-x1);
    }
    
    public double getM(Point2D p1, Point2D p2)
    {
        return (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
    }
    
    public double getM(Line2D line)
    {
        return (line.getY2()-line.getY1())/(line.getX2()-line.getX1());
    }
    
    public double getX(Point2D point, double m, double y)
    {
        return point.getX()+(y - point.getY())/m;
    }
    
    public double getY(Point2D point, double m, double x)
    {
        return m*(x-point.getX())+point.getY();
    }
    
    public void orientationY(Point2D point, Line2D line)
    {
        double y = getY(line.getP1(), getM(line), point.getX());
        if(y>point.getY())
        {
            System.out.println("Point: Above The Line"); //y coordinat in java is different
        }
        else if(y<point.getY())
        {
            System.out.println("Point: Under The Line"); //y coordinat in java is different
        }
        else
        {
            System.out.println("Point: Collinear"); //y coordinat in java is different
        }
    }
    
    public void orientationY()
    {
        double y = getY(line3.getP1(), getM(line3), point.getX());
        if(y>point.getY())
        {
            System.out.println("Point: Above The Line"); //y coordinat in java is different
        }
        else if(y<point.getY())
        {
            System.out.println("Point: Under The Line"); //y coordinat in java is different
        }
        else
        {
            System.out.println("Point: Collinear"); //y coordinat in java is different
        }
    }
    
    public void test(double x, double y)
    {
        Line2D line = line3;
        System.out.println(line.relativeCCW(x, y));
    }
}
