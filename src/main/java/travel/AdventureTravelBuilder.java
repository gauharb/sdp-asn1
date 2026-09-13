package travel;

public class AdventureTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "Mountain hostel";
    private static final String DEFAULT_TRANSPORT = "4x4 off-road vehicle";
    private static final String DEFAULT_MEALS = "Self-catered / trail food";
    private static final String DEFAULT_ACTIVITIES = "Hiking, rafting, camping";

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