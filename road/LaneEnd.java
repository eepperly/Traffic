package road;

/**
 * Created by eepperly16 on 11/16/15.
 */
public class LaneEnd extends Lane {
	public LaneEnd(Lane rightLane, Lane leftLane, Lane nextLane, double speedLimit, double endOfLane) {
		super(rightLane, leftLane, nextLane, speedLimit, endOfLane);
	}
}
