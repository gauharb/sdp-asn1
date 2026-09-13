package travel;

public class RelaxationTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "All-inclusive beach resort";
    private static final String DEFAULT_TRANSPORT = "Hotel airport transfer";
    private static final String DEFAULT_MEALS = "All-inclusive buffet";
    private static final String DEFAULT_ACTIVITIES = "Spa, pool, beach lounging";

    @Override
    protected void applyDefaults() {
        applyDefault(travelPackage::getHotel, travelPackage::setHotel, DEFAULT_HOTEL);
        applyDefault(travelPackage::getTransport, travelPackage::setTransport, DEFAULT_TRANSPORT);
        applyDefault(travelPackage::getMeals, travelPackage::setMeals, DEFAULT_MEALS);
        applyDefault(travelPackage::getActivities, travelPackage::setActivities, DEFAULT_ACTIVITIES);
    }
}