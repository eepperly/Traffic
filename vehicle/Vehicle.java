package vehicle;

import road.Lane;
import road.Traffic;
import driver.Driver;
/**
 * Created by eepperly16 on 10/24/15.
 */
public abstract class Vehicle {
    protected Lane lane;
    protected Driver driver;
    protected Traffic traffic;

    //physical parameters of the vehicle
    protected double length;
    protected double maxAccel;
    protected double maxDecel;
    protected final double DELTA=4;

    //current status
    protected double x;
    protected double v;

    public Vehicle(){
        lane = null;
        traffic = null;
        driver = null;
    }

    public Vehicle(Lane lane, Driver driver, Traffic traffic, double length, double maxAccel, double maxDecel, double timeHeadway, double spaceHeadway, double speedingParameter, double x, double v) {
        this.lane = lane;
        this.driver = driver;
        this.traffic = traffic;
        this.length = length;
        this.maxAccel = maxAccel;
        this.maxDecel = maxDecel;
        this.x = x;
        this.v = v;
    }

    public Vehicle(Lane lane,Driver driver,Traffic traffic,double x, double v) {
        this.lane = lane;
        this.driver = driver;
        this.traffic = traffic;
        length = 5;
        maxAccel = 1;
        maxDecel = 3;
        this.x = x;
        this.v = v;
    }

    public Vehicle(Lane lane, Driver driver, Traffic traffic, double length, double maxAccel, double maxDecel, double timeHeadway, double spaceHeadway, double speedingParameter) {
        this.lane = lane;
        this.driver = driver;
        this.traffic = traffic;
        this.length = length;
        this.maxAccel = maxAccel;
        this.maxDecel = maxDecel;
        x = 0.0;
        v = 0.0;
    }

    public double getLength() {
        return length;
    }

    public double getX() {

        return x;
    }

    public void setLane(Lane lane){
        this.lane = lane;
        driver.setLane(lane);
    }

    public double getV() {
        return v;
    }
    public abstract void advance(Vehicle inFront);

    public String toString(){
        return (x+"   "+v);
    }
}
