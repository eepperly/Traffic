package driver;

import road.Lane;
import vehicle.Vehicle;

/**
 * Created by eepperly16 on 10/25/15.
 */
public class StandardDriver extends Driver{
    private double timeHeadwayValue, spaceHeadwayValue, speedingParameter;
    public StandardDriver(){
        super();
        timeHeadwayValue = 1.5;
        spaceHeadwayValue = 2;
        speedingParameter = 5;
    }
    public StandardDriver(Lane lane){
        super(lane);
        timeHeadwayValue = 1.5;
        spaceHeadwayValue = 2;
        speedingParameter = 5;
    }
    public StandardDriver(Lane lane,Vehicle vehicle){
        super(lane,vehicle);
        timeHeadwayValue = 1.5;
        spaceHeadwayValue = 2;
        speedingParameter = 5;
    }
    public StandardDriver(Lane lane, Vehicle vehicle, double timeHeadwayValue, double spaceHeadwayValue, double speedingParameter) {
        super(lane, vehicle);
        this.timeHeadwayValue = timeHeadwayValue;
        this.spaceHeadwayValue = spaceHeadwayValue;
        this.speedingParameter = speedingParameter;
    }

    public double timeHeadway(){
        return timeHeadwayValue;
    }

    public double spaceHeadway(){
        return spaceHeadwayValue;
    }

    public double desiredVelocity(){
        return lane.getSpeedLimit()+speedingParameter;
    }
}
