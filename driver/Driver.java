package driver;
import road.Lane;
import vehicle.Vehicle;
/**
 * Created by eepperly16 on 10/24/15.
 */
public abstract class Driver {
    protected Lane lane;
    protected Vehicle vehicle;
    public Driver(){
        lane = null;
        vehicle = null;
    }

    public Driver(Lane lane){
        this.lane = lane;
        vehicle = null;
    }

    public Driver(Lane lane, Vehicle vehicle) {
        this.lane = lane;
        this.vehicle = vehicle;
    }

    public void setLane(Lane lane){
        this.lane = lane;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public abstract double timeHeadway();
    public abstract double spaceHeadway();
    public abstract double desiredVelocity();
}
