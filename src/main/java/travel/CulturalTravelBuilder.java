package travel;

public class CulturalTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "Boutique hotel in city center";
    private static final String DEFAULT_TRANSPORT = "Public transport / walking tours";
    private static final String DEFAULT_MEALS = "Local cuisine tasting tours";
    private static final String DEFAULT_ACTIVITIES = "Museums, guided tours, historic sites";

    @Override
    protected void applyDefaults() {
        applyDefault(travelPackage::getHotel, travelPackage::setHotel, DEFAULT_HOTEL);
        applyDefault(travelPackage::getTransport, travelPackage::setTransport, DEFAULT_TRANSPORT);
        applyDefault(travelPackage::getMeals, travelPackage::setMeals, DEFAULT_MEALS);
        applyDefault(travelPackage::getActivities, travelPackage::setActivities, DEFAULT_ACTIVITIES);
    }
}