package travel;

public abstract class TravelPackageBuilder {

    protected final TravelPackage travelPackage = new TravelPackage();

    public TravelPackageBuilder setDestination(String destination) {
        travelPackage.setDestination(destination);
        return this;
    }

    public TravelPackageBuilder setHotel(String hotel) {
        travelPackage.setHotel(hotel);
        return this;
    }

    public TravelPackageBuilder setFlight(String flight) {
        travelPackage.setFlight(flight);
        return this;
    }

    public TravelPackageBuilder setTransport(String transport) {
        travelPackage.setTransport(transport);
        return this;
    }

    public TravelPackageBuilder setMeals(String meals) {
        travelPackage.setMeals(meals);
        return this;
    }

    public TravelPackageBuilder setActivities(String activities) {
        travelPackage.setActivities(activities);
        return this;
    }

    // Template method: every subclass gets the same defaulting + validation
    // sequence for free, so none of them can skip or duplicate it.
    public final TravelPackage build() {
        applyDefaults();
        validate();
        return travelPackage;
    }

    protected abstract void applyDefaults();

    private void validate() {
        if (travelPackage.getDestination() == null || travelPackage.getDestination().isBlank()) {
            throw new IllegalStateException("Cannot build TravelPackage: destination is required");
        }
        if (travelPackage.getFlight() == null || travelPackage.getFlight().isBlank()) {
            throw new IllegalStateException("Cannot build TravelPackage: flight is required");
        }
    }
}
