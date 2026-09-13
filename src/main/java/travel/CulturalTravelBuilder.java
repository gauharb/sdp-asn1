package travel;

public class CulturalTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "Boutique hotel in city center";
    private static final String DEFAULT_TRANSPORT = "Public transport / walking tours";
    private static final String DEFAULT_MEALS = "Local cuisine tasting tours";
    private static final String DEFAULT_ACTIVITIES = "Museums, guided tours, historic sites";

    @Override
    protected void applyDefaults() {
        if (travelPackage.getHotel() == null) {
            travelPackage.setHotel(DEFAULT_HOTEL);
        }
        if (travelPackage.getTransport() == null) {
            travelPackage.setTransport(DEFAULT_TRANSPORT);
        }
        if (travelPackage.getMeals() == null) {
            travelPackage.setMeals(DEFAULT_MEALS);
        }
        if (travelPackage.getActivities() == null) {
            travelPackage.setActivities(DEFAULT_ACTIVITIES);
        }
    }
}