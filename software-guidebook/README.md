# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context

De Triptop applicatie dient om reizigers te helpen met het plannen van een reis. De software zal door reisagenten gebruikt worden om verschillende reizen van te voren samen te stellen, waarbij reizigers deze kunnen kiezen en eventueel elk individuele bouwsteen van deze reis aanpassen (denk aan bijvoorbeeld de overnachting, vervoer en activiteiten). De software maakt gebruik van externe systemen zoals verschillende api's.

![Context diagram](/diagrammen-met-de-boys/ContextDiagram.png)
_Afbeelding 1: Context diagram van de Triptop applicatie._

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren 

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principles

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

## 7. Software Architecture

###     7.1. Containers

> [!IMPORTANT]
![Container Diagram](/diagrammen-met-de-boys/Containerdiagram.png)
> Afbeelding 2: Container diagram van de Triptop applicatie.

![Dynamic Diagram Login](/diagrammen-met-de-boys/DynamicDiagramLogin.png)
> Afbeelding 3: Dynamic diagram van het inloggen in de Triptop applicatie.

![Dynamic Diagram Reis boeken](/diagrammen-met-de-boys/DynamicDiagramReisBoeken.png)
> Afbeelding 4: Dynamic diagram van het boeken van een reis in de Triptop applicatie.

###     7.2. Components

> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

###     7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

## 8. Architectural Decision Records

> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

### 8.1. ADR-001 Het gebruik van postman voor prototypes
#### Context 
Als groep hebben wij prototypes moeten maken voor de API's die wij benoemen in het containerdiagram/C4-diagrammen.
Als groep wouden wij een manier hebben hoe wij test's schreven voor de API's, Zodat we voorkomen dat de ene een hele Java-Applicatie gaat maken en de ander Postman gaat gebruiken. 
#### Considered Options
- Postman
- Een eigen Java-applicatie maken om te testen

|                       | Documentatie | Overzichtelijkheid | Geeft error's duidelijk weer |
|-----------------------|--------------|--------------------|------------------------------|
| Postman               | ++           | ++                 | ++                           |     
| Eigen Java-Applicatie | +            | *                  | ++                           |     

#### Decision
Wij hebben besloten om Postman te gebruiken.  
De reden hiervoor is dat iedereen in onze groep bekend is met Postman en dat het een snelle en eenvoudige manier biedt om te testen of endpoints werken.
#### Status 
**Voorgesteld**

#### Consequences 
### Positief
- In Postman kun je eenvoudig requests groeperen in een collectie. Dit zorgt voor meer overzicht, bijvoorbeeld door aparte collecties te maken voor hotels en vluchten.
- Postman biedt de mogelijkheid om een Workspace te gebruiken en te delen met het team, zodat iedereen met dezelfde requests werkt.

### Neutraal
- Requests kunnen een naam krijgen, waardoor ze eenvoudig terug te vinden en te onderscheiden zijn.

### Negatief
- Voor mensen die nog nooit met Postman hebben gewerkt, kan het in het begin onduidelijk zijn.
- Als Postman niet beschikbaar is, kunnen we de API's niet testen, omdat alles binnen Postman staat.
- Wij gebruiken de gratis versie van Postman, mocht het veranderen dat wij moeten betalen moeten wij overstappen naar een andere optie. 


### 8.2. ADR-002 Opslaan van JDBC token

#### Context

Voor de authenticatie en authorisatie in de software maken we gebruik van een externe API. Deze API geeft een token terug bij een succesvolle login die wij kunnen opslaan en versturen naar andere API's om aan te tonen dat het een geautoriseerde gebruiker is en wat zijn rechten zijn in de software. Er zijn verschillende mogelijkheden voor waar we deze token willen opslaan, elk met zijn eigen voor- en nadelen.

#### Considered Options

|                   | Veiligheid    | Toegankelijkheid  | Persistentie  |
|-----------------  |------------   |------------------ |-------------- |
| Local Storage     | --            | ++                | --            |
| Session Storage   | ++            | +                 | ++            |

_Tabel 2: ADR-002 Considered Options._

Het is handig om te vermelden dat alhoewel we bedoelen met persistentie of dat de token bewaard blijft als de browser sluit is dit juist een nadeel. De plusjes betekenen dat dit niet wordt bewaard en de minnetjes dus dat het wel bewaard blijft.

#### Decision

Wij gaan de JDBC tokens opslaan in de session storage. Hier hebben wij voor gekozen sinds dit een veiligere optie is dan de Local Storage terwijl het niet veel minder toegankelijk is. Daarnaast hebben wij in het team ook meer kennis over session storage dan local storage.

#### Status

Proposed

#### Consequences

We hebben deze optie nog niet toegepast. We kunnen dus nog niet de gevolgen die dit heeft opgeleverd noteren.

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

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

### 8.4. ADR-004 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

### 8.5. ADR-005 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.