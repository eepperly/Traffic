package main;

import driver.Driver;
import driver.StandardDriver;
import road.Lane;
import road.Traffic;
import vehicle.Car;
import vehicle.Vehicle;

/**
 * Created by eepperly16 on 10/25/15.
 */
public class Runner {
    public static void main(String[] args) {
        Lane onlyLane = new Lane(null, null, null, 26.82, 500.0);
        Lane nextLane = new Lane(null,null,null,0.75*26.82,1000.0);
        onlyLane.setNextLane(nextLane);

        Traffic traffic = new Traffic(1.0, onlyLane);

        int numDrivers = 10;
        Driver driver;
        Vehicle vehicle;
        for (int i = 0; i < numDrivers; i++) {
            driver = new StandardDriver(onlyLane);
            vehicle = new Car(onlyLane, driver, traffic, (numDrivers - 1 - i) * 10 + 6, 0);
            onlyLane.addFirstVehicle(vehicle);
        }
        while (traffic.getTime()<100.0){
            System.out.println(traffic);
            traffic.advance();
            System.out.println("Lane 1: "+onlyLane.getVehicles().size());
            System.out.println("Lane 2: "+nextLane.getVehicles().size());
        }
    }
}
