package travel;

public class Director {

    public TravelPackage buildPatagoniaAdventureTrek(TravelPackageBuilder builder) {
        return builder
                .setDestination("Patagonia, Argentina")
                .setFlight("Economy flight to El Calafate")
                .build();
    }

    public TravelPackage buildBaliRelaxationWeek(TravelPackageBuilder builder) {
        return builder
                .setDestination("Bali, Indonesia")
                .setFlight("Business flight to Denpasar")
                .build();
    }

    public TravelPackage buildRomeCulturalTour(TravelPackageBuilder builder) {
        return builder
                .setDestination("Rome, Italy")
                .setFlight("Economy flight to Fiumicino")
                .build();
    }
}