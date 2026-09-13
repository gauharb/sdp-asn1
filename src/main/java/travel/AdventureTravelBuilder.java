package travel;

public class AdventureTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "Mountain hostel";
    private static final String DEFAULT_TRANSPORT = "4x4 off-road vehicle";
    private static final String DEFAULT_MEALS = "Self-catered / trail food";
    private static final String DEFAULT_ACTIVITIES = "Hiking, rafting, camping";

    @Override
    protected void applyDefaults() {
        applyDefault(travelPackage::getHotel, travelPackage::setHotel, DEFAULT_HOTEL);
        applyDefault(travelPackage::getTransport, travelPackage::setTransport, DEFAULT_TRANSPORT);
        applyDefault(travelPackage::getMeals, travelPackage::setMeals, DEFAULT_MEALS);
        applyDefault(travelPackage::getActivities, travelPackage::setActivities, DEFAULT_ACTIVITIES);
    }
}