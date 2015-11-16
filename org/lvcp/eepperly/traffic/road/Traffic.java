package org.lvcp.eepperly.traffic.road;

/**
 * Created by eepperly16 on 10/24/15.
 */
public class Traffic {
    private double dt;
    private double time;
    private Lane rightMostLane;

    public Traffic(double dt, Lane rightMostLane) {
        this.dt = dt;
        this.rightMostLane = rightMostLane;
        time = 0;
    }

    public double getDt() {
        return dt;
    }

    public String toString(){
        return "TIME: "+time+"\n"+laneToString(rightMostLane);
    }

    public double getTime() {
        return time;
    }

    public String laneToString(Lane lane){
        String str = ""+lane;
        if (lane.getLeftLane()!=null){
            str += laneToString(lane.getLeftLane())+"\n";
        }
        if (lane.getNextLane()!=null){
            str += laneToString(lane.getNextLane())+"\n";
        }
        return str+"\n";
    }
    public void advance(){
        advanceLane(rightMostLane);
        advanceCarsToNewLanes(rightMostLane);
        time += dt;
    }
    public void advanceLane(Lane lane){
        lane.advance();
        if (lane.getLeftLane()!=null){
            advanceLane(lane.getLeftLane());
        }
        if (lane.getNextLane()!=null){
            advanceLane(lane.getNextLane());
        }
    }
    public void advanceCarsToNewLanes(Lane lane){
        lane.advanceCarsToNextLane();
        if (lane.getLeftLane()!=null){
            advanceCarsToNewLanes(lane.getLeftLane());
        }
        if (lane.getNextLane()!=null){
            advanceCarsToNewLanes(lane.getNextLane());
        }
    }
}
