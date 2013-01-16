/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testline;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

/**
 *
 * @author Radhitya
 */
public class LineDrawing {
    
    Line2D line1 = new Line2D.Double(0, 0, 200, 200);
    Line2D line2 = new Line2D.Double(70, 80, 100, 200);
    Line2D line3 = new Line2D.Double(100, 150, 150,150);
    
    //Point2D
    
    Stroke drawingStroke = new BasicStroke(2);

    public void paint(Graphics g)
    {
        Graphics2D graph = (Graphics2D)g;
        graph.setStroke(drawingStroke);
        graph.setPaint(Color.green);
        graph.draw(line1);
        graph.setPaint(Color.red);
        graph.draw(line2);
        graph.setPaint(Color.yellow);
        graph.draw(line3);

    }
}
