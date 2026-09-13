package travel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private enum TravelType {
        ADVENTURE(
                new String[]{"Patagonia, Argentina", "Iceland", "New Zealand", "Swiss Alps", "Nepal"},
                new String[]{"Hiking", "Rafting", "Camping", "Mountain climbing", "Safari", "Zip-lining"}
        ),
        RELAXATION(
                new String[]{"Bali, Indonesia", "Maldives", "Phuket, Thailand", "Santorini, Greece", "Seychelles"},
                new String[]{"Spa", "Beach activities", "Swimming", "Yoga", "Boat cruise", "Meditation retreat"}
        ),
        CULTURAL(
                new String[]{"Rome, Italy", "Paris, France", "Kyoto, Japan", "Istanbul, Turkey", "Cairo, Egypt"},
                new String[]{"Museums", "Guided tours", "Historical sites", "Cooking class", "Art galleries", "Local markets"}
        );

        final String[] destinations;
        final String[] activities;

        TravelType(String[] destinations, String[] activities) {
            this.destinations = destinations;
            this.activities = activities;
        }
    }

    private static final String[] FLIGHT_OPTIONS = {"Economy flight", "Business flight", "First Class flight"};
    private static final String[] HOTEL_OPTIONS = {"Standard hotel", "Boutique hotel", "Luxury resort", "Eco lodge", "Hostel", "Apartment rental"};
    private static final String[] TRANSPORT_OPTIONS = {"Public transport", "Rental car", "Hotel transfer", "4x4 vehicle", "Private driver", "Bicycle rental"};
    private static final String[] MEALS_OPTIONS = {"Self-catered", "Local cuisine", "Breakfast included", "Half board", "All-inclusive", "Fine dining package"};

    private static final String SECTION_DIVIDER = "   ";

    public static void main(String[] args) {
        System.out.println("     TRAVEL PACKAGE BUILDER");

        runDirectorDemo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(SECTION_DIVIDER);
            System.out.print("\nWould you like to build your own custom package? (y/n): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("y")) {
                buildCustomPackage(scanner);
            }
        }
    }

    private static void runDirectorDemo() {
        Director director = new Director();

        TravelPackage adventure = director.buildPatagoniaAdventureTrek(new AdventureTravelBuilder());
        TravelPackage relaxation = director.buildBaliRelaxationWeek(new RelaxationTravelBuilder());
        TravelPackage cultural = director.buildRomeCulturalTour(new CulturalTravelBuilder());

        System.out.println("\n   PRESET PACKAGES (built via Director)   ");
        printPackage("Adventure preset", adventure);
        printPackage("Relaxation preset", relaxation);
        printPackage("Cultural preset", cultural);
    }

    private static void printPackage(String label, TravelPackage travelPackage) {
        System.out.println(SECTION_DIVIDER);
        System.out.println(label);
        System.out.println(travelPackage);
    }

    private static void buildCustomPackage(Scanner scanner) {
        TravelType type = promptEnum(scanner, "\nChoose travel type:",
                new String[]{"Adventure", "Relaxation", "Cultural"}, TravelType.values());
        if (type == null) return;

        TravelPackageBuilder builder = createBuilder(type);

        String destination = promptFromList(scanner, "\nChoose destination:", type.destinations);
        if (destination == null) return;
        builder.setDestination(destination);

        String flight = promptFromList(scanner, "\nChoose flight:", FLIGHT_OPTIONS);
        if (flight == null) return;
        builder.setFlight(flight);

        String hotel = promptFromList(scanner, "\nChoose hotel:", HOTEL_OPTIONS);
        if (hotel == null) return;
        builder.setHotel(hotel);

        String transport = promptFromList(scanner, "\nChoose transport:", TRANSPORT_OPTIONS);
        if (transport == null) return;
        builder.setTransport(transport);

        String meals = promptFromList(scanner, "\nChoose meals:", MEALS_OPTIONS);
        if (meals == null) return;
        builder.setMeals(meals);

        String activities = promptFromList(scanner, "\nChoose activities:", type.activities);
        if (activities == null) return;
        builder.setActivities(activities);

        TravelPackage travelPackage = builder.build();

        printPackage("   YOUR CUSTOM PACKAGE", travelPackage);
        System.out.println("\n   Have a great time!\uD83C\uDF89\uD83C\uDF89      ");
    }

    private static TravelPackageBuilder createBuilder(TravelType type) {
        switch (type) {
            case ADVENTURE:
                return new AdventureTravelBuilder();
            case RELAXATION:
                return new RelaxationTravelBuilder();
            case CULTURAL:
                return new CulturalTravelBuilder();
            default:
                throw new IllegalStateException("Unexpected type: " + type);
        }
    }

    private static <T> T promptEnum(Scanner scanner, String title, String[] labels, T[] values) {
        while (true) {
            System.out.println(title);
            for (int i = 0; i < labels.length; i++) {
                System.out.println((i + 1) + ". " + labels[i]);
            }
            System.out.print("Choice: ");

            int choice = readInt(scanner);
            if (choice >= 1 && choice <= values.length) {
                return values[choice - 1];
            }
            System.out.println("Invalid choice.Please try again");
        }
    }

    private static String promptFromList(Scanner scanner, String title, String[] options) {
        return Main.<String>promptEnum(scanner, title, options, options);
    }

    private static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return -1;
        }
    }
}
