### ADR-003 BookingAPI wordt gebruikt voor hotels, vluchten en autoverhuur

#### Context

Wij zochten API's die wij konden gebruiken voor het zoeken van hotels, vluchten en autoverhuur.

#### Considered Options

|                 | Documentatie | Betrouwbaarheid | Schaalbaarheid |
|-----------------|--------------|-----------------|----------------|
| Booking.com     | ++           | ++              | ++             |
| Flights scraper | -            | -               | -              |
| Priceline.com   | ++           | ++              | ++             |
| TravelData      | +            | +               | +              |


_Tabel 3: ADR-003 Considered Options._

Booking.com en Priceline.com bieden uitgebreide documentatie, zijn betrouwbaar en schaalbaar door hun grote gebruikersbasis. Flights scraper is vaak minder betrouwbaar en schaalbaar, afhankelijk van het scrapen van gegevens. TravelData heeft gemiddelde documentatie, betrouwbaarheid en schaalbaarheid.

#### Decision

Wij hebben besloten om Booking.com te gebruiken voor het zoeken van hotels, vluchten en autoverhuur. Dit is omdat Booking.com uitgebreide documentatie biedt, betrouwbaar is en schaalbaar is door zijn grote gebruikersbasis en het is bekender binnen de team dan Priceline.com.

#### Status

Proposed

#### Consequences

We hebben deze optie nog niet toegepast. We kunnen dus nog niet de gevolgen die dit heeft opgeleverd noteren.

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.