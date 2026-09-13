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

    public String getDestination() {
        return destination;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHotel() {
        return hotel;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFlight() {
        return flight;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransport() {
        return transport;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getMeals() {
        return meals;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getActivities() {
        return activities;
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