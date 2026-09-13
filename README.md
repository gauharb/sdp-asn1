# Travel Package Builder

**SE-2530:** Baimagambet Gauhar

## What this is ?

A demonstration of the **Builder** creational design pattern applied to
travel package planning.

Assembling a trip genuinely benefits from step-by-step construction:
the same construction steps (destination, flight, hotel, transport,
meals, activities) can produce different final packages depending on
which concrete builder is used.

The system provides three travel styles:

- **Adventure** — outdoor and active travel
- **Relaxation** — beach, spa and wellness travel
- **Cultural** — museums, historical sites and guided tours

If the client skips optional construction steps, the selected builder
provides sensible default values.

## Structure

```text
src/main/java/travel/
├── TravelPackage.java             # Product — final travel package
├── TravelPackageBuilder.java      # Builder — shared fluent setters and validation
├── AdventureTravelBuilder.java    # ConcreteBuilder — adventure travel
├── RelaxationTravelBuilder.java   # ConcreteBuilder — relaxation travel
├── CulturalTravelBuilder.java     # ConcreteBuilder — cultural travel
├── Director.java                  # Director — reusable trip presets
└── Main.java                      # Client — preset demo and custom builder
````

## How to build each representation

### Preset trips via Director

The `Director` provides reusable configurations for common travel
packages:

```java
Director director = new Director();

TravelPackage adventure =
        director.buildPatagoniaAdventureTrek(new AdventureTravelBuilder());

TravelPackage relaxation =
        director.buildBaliRelaxationWeek(new RelaxationTravelBuilder());

TravelPackage cultural =
        director.buildRomeCulturalTour(new CulturalTravelBuilder());
```

### Custom trip

The client can also build a package directly using any concrete builder:

```java
TravelPackage package = new CulturalTravelBuilder()
        .setDestination("Rome, Italy")
        .setFlight("Economy flight to Fiumicino")
        .setHotel("Trastevere boutique hotel")
        .setActivities("Colosseum tour, Vatican museums, cooking class")
        .build();
```

Any optional step that is not specified is filled in with the default
value provided by the selected concrete builder.

For example, if transport and meals are not specified in a cultural
package, the `CulturalTravelBuilder` provides appropriate defaults.

### Interactive custom trip

Running `Main` first displays the three preset packages and then allows
the user to build a custom package through a console menu.

The user selects:

1. Travel type
2. Destination
3. Flight
4. Hotel
5. Transport
6. Meals
7. Activities

All options are selected from predefined lists.

Calling `build()` without a destination or flight throws
`IllegalStateException` with a clear error message. These required
fields are validated in `TravelPackageBuilder`.

## How to run

Requires **JDK 17+**.

```bash
javac -d out src/main/java/travel/*.java
java -cp out travel.Main
```

## Design notes

* `TravelPackageBuilder.build()` uses the **Template Method** approach:
  it applies builder-specific defaults, validates the package, and then
  returns the completed `TravelPackage`.

* `TravelPackageBuilder` contains the common fluent setters and
  validation logic. This prevents the three concrete builders from
  duplicating the same construction logic.

* `applyDefault(Supplier<String>, Consumer<String>, String)` is a shared
  helper for applying a default value only when the client has not
  provided one.

* `AdventureTravelBuilder`, `RelaxationTravelBuilder`, and
  `CulturalTravelBuilder` provide different default representations of
  a travel package.

* All fluent setters return `TravelPackageBuilder`, which allows
  method chaining.

* `Director` contains reusable configurations for common travel
  packages, while `Main` demonstrates both preset and custom package
  construction.

``````


