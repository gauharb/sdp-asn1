package travel;

public class RelaxationTravelBuilder extends TravelPackageBuilder {

    private static final String DEFAULT_HOTEL = "All-inclusive beach resort";
    private static final String DEFAULT_TRANSPORT = "Hotel airport transfer";
    private static final String DEFAULT_MEALS = "All-inclusive buffet";
    private static final String DEFAULT_ACTIVITIES = "Spa, pool, beach lounging";

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