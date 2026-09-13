package travel;

public interface TravelPackageBuilder {

    TravelPackageBuilder setDestination(String destination);

    TravelPackageBuilder setHotel(String hotel);

    TravelPackageBuilder setFlight(String flight);

    TravelPackageBuilder setTransport(String transport);

    TravelPackageBuilder setMeals(String meals);

    TravelPackageBuilder setActivities(String activities);

    TravelPackage build();
}
