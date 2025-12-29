package design_pattern.strategy_pattern;

interface MatchingStrategy{
    void match(String riderLocation);
}

class NearestDriverStrategy implements MatchingStrategy{

    @Override
    public void match(String riderLocation) {
        System.out.println("Matching with the nearest available driver to "+riderLocation);
        // Distance-based matching logic
    }
}

class AirportQueueStrategy implements MatchingStrategy{

    @Override
    public void match(String riderLocation) {
        System.out.println("Matching using FIFO airport queue for "+riderLocation);
        // Match first-in-line driver for airport pickup
    }
}

class RideMatchingService{
    private MatchingStrategy matchingStrategy;

    public RideMatchingService(MatchingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public void setMatchingStrategy(MatchingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public void matchRider(String location){
        matchingStrategy.match(location);
    }
}

class SurgePriorityStrategy implements MatchingStrategy{

    @Override
    public void match(String riderLocation) {
        System.out.println("Matching rider using surge pricing priority near "+riderLocation);
        // Priority high-surge zones or premium drivers
    }
}

public class StrategyPatternMain {
    public static void main(String[] args) {
        RideMatchingService rideMatchingService = new RideMatchingService(new AirportQueueStrategy());
        rideMatchingService.matchRider("Kolkata Airport");

        rideMatchingService.setMatchingStrategy(new SurgePriorityStrategy());
        rideMatchingService.matchRider("Kolkata Airport");
    }
}
