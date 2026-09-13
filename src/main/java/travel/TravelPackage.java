package travel;

public class TravelPackage {

    private String destination;
    private String hotel;
    private String flight;
    private String transport;
    private String meals;
    private String activities;

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Travel Package\n" +
                "Destination: " + destination + "\n" +
                "Hotel: " + hotel + "\n" +
                "Flight: " + flight + "\n" +
                "Transport: " + transport + "\n" +
                "Meals: " + meals + "\n" +
                "Activities: " + activities;
    }
}