package org.lvcp.eepperly.traffic.vehicle;

import org.lvcp.eepperly.traffic.driver.Driver;
import org.lvcp.eepperly.traffic.road.Lane;
import org.lvcp.eepperly.traffic.road.Traffic;

/**
 * Created by eepperly16 on 10/24/15.
 */
public class Car extends Vehicle {
    public Car() {
    }

    public Car(Lane lane, Driver driver, Traffic traffic, double length, double maxAccel, double maxDecel, double timeHeadway, double spaceHeadway, double speedingParameter, double x, double v) {
        super(lane, driver, traffic, length, maxAccel, maxDecel, timeHeadway, spaceHeadway, speedingParameter, x, v);
    }

    public Car(Lane lane, Driver driver, Traffic traffic, double x, double v) {
        super(lane, driver, traffic, x, v);
    }

    public Car(Lane lane, Driver driver, Traffic traffic, double length, double maxAccel, double maxDecel, double timeHeadway, double spaceHeadway, double speedingParameter) {
        super(lane, driver, traffic, length, maxAccel, maxDecel, timeHeadway, spaceHeadway, speedingParameter);
    }

    private double acceleration(Vehicle inFront){
        double netDistance, approachingRate, followingDistanceTerm;
        if (inFront!=null){
            netDistance = x - inFront.getX() - inFront.getLength();
            approachingRate = v - inFront.getV();
        }
        else{
            netDistance = x - lane.getReallyEndOfLane();
            approachingRate = v;
        }
        followingDistanceTerm = driver.spaceHeadway() + Math.max(0,v*driver.timeHeadway() + v*approachingRate/2/Math.sqrt(maxAccel*maxDecel));
        return maxAccel * (1 - Math.pow(v/driver.desiredVelocity(),DELTA) - Math.pow(followingDistanceTerm/netDistance,2));
    }
    public void advance(Vehicle inFront){
        double k1, k2, k3, k4, l1, l2, l3, l4;
        double dt = traffic.getDt();
        k1 = v;
        l1 = acceleration(inFront);
        x += dt * k1 / 2;
        v += dt * l1 / 2;

        k2 = v;
        l2 = acceleration(inFront);
        x += dt * (k2 - k1) / 2;
        v += dt * (l2 - l1) / 2;

        k3 = v;
        l3 = acceleration(inFront);
        x += dt * (2 * k3 - k2) / 2;
        v += dt * (2 * l3 - l2) / 2;

        k4 = v;
        l4 = acceleration(inFront);
        x -= dt * k3;
        v -= dt * l3;

        x += dt * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
        v += dt * (l1 + 2 * l2 + 2 * l3 + l4) / 6;
    }
}
