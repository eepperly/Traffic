package org.lvcp.eepperly.traffic.main;

import org.lvcp.eepperly.traffic.road.Traffic;
import org.lvcp.eepperly.traffic.road.Lane;
import org.lvcp.eepperly.traffic.driver.Driver;
import org.lvcp.eepperly.traffic.driver.StandardDriver;
import org.lvcp.eepperly.traffic.vehicle.Vehicle;
import org.lvcp.eepperly.traffic.vehicle.Car;


import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * Created by eepperly16 on 10/25/15.
 */
public class VisualDisplay extends JPanel {
    public VisualDisplay(){                       // set up graphics window
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){  // draw graphics in the panel
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly

        double laneWidth = 50;
        g.drawLine(0,(int) (height/2.0+laneWidth/2),width,(int) (height/2.0+laneWidth/2));
        g.drawLine(0,(int) (height/2.0-laneWidth/2),width,(int) (height/2.0-laneWidth/2));
    }

    public static void main(String[] args){
        Lane onlyLane = new Lane(null,null,null,26.82,500.0);
        Traffic traffic = new Traffic(0.1,onlyLane);

        int numDrivers = 10;
        Driver driver;
        Vehicle vehicle;
        for (int i=0;i<numDrivers;i++){
            driver = new StandardDriver(onlyLane);
            vehicle = new Car(onlyLane,driver,traffic,(numDrivers-1-i)*10+6,0);
            onlyLane.addFirstVehicle(vehicle);
        }

        VisualDisplay panel = new VisualDisplay();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(500, 400);         // window is 500 pixels wide, 400 high
        application.setVisible(true);
    }



}
