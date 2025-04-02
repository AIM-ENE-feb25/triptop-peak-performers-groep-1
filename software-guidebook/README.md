# Software Guidebook Triptop
## 1. Introductie
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
2. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
3. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
4. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context
De Triptop applicatie dient om reizigers te helpen met het plannen van een reis. De software zal door reisagenten gebruikt worden om verschillende reizen van te voren samen te stellen, waarbij reizigers deze kunnen kiezen en eventueel elk individuele bouwsteen van deze reis aanpassen (denk aan bijvoorbeeld de overnachting, vervoer en activiteiten). De software maakt gebruik van externe systemen zoals verschillende api's (zie afbeelding 1).

![Context diagram](/opdracht-diagrammen/C4-Diagrammen/ContextDiagram.png)
_Afbeelding 1: Context diagram van de Triptop applicatie._

## 3. Functioneel overzicht
Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt. En een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

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
_Afbeelding 2: Domain Story AS IS._

### 3.3 Domain Story Reis Boeken (TO BE)
![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)
_Afbeelding 3: Domain Story TO BE._

### 3.4 Domain Model
![Domain Model](../opdracht-diagrammen/DomainModel/Domain%20Model.png)
_Afbeelding 4: Domain Model._

## 4. Kwaliteitattributen
Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Beperkingen
> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principes
> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

## 7. Software Architecture
### 7.1. Externe api's
| Naam              | Doel        | Links | 
|-------------------|-------------|-------|
| Booking.Com       | Hotels      |       |    
| TripAdvisorApi    | Restaurants |       |   
| GoogleFlightsAPI  | Vluchten    |       |

_Tabel 1: Externe api's._

### 7.2. Containers
![Container Diagram](/opdracht-diagrammen/C4-Diagrammen/Containerdiagram.png)
_Afbeelding 5: Container diagram._

![Dynamic Diagram Login](/opdracht-diagrammen/C4-Diagrammen/DynamicDiagramLogin.png)
_Afbeelding 6: Dynamic Diagram login._

![Dynamic Diagram Reis boeken](/opdracht-diagrammen/C4-Diagrammen/DynamicDiagramReisBoeken.png)
_Afbeelding 7: Dynamic Diagram reis boeken._

### 7.3. Componenten
#### 7.3.1. Hoe zorg je ervoor dat authenticatie en autorisatie consistent worden toegepast bij het communiceren met verschillende externe API's?
##### Component diagram
Voor deze onderzoeksvraag hebben we als eerste een component diagram gemaakt. Wij hebben voor het onderzoeken van deze onderzoeksvraag gebruik gemaakt van het strategy pattern. Dit houdt in dat er door een interface de juiste implementatie van de methode (om te authenticeren) wordt aangeroepen. Zo kan je verschillende strategieën (zoals username, key of secret) implementeren voor het authenticeren zonder andere code in je applicatie te hoeven wijzigen. Dit maakt het mogelijk om eenvoudig te schakelen tussen verschillende authenticatiemethoden.

Dit diagram toont de architectuur van de Triptop applicatie, inclusief de interactie tussen de gebruiker en het systeem. Dit diagram is gefocust op het authenticeren van een gebruiker voor het versturen van API verzoeken (zie afbeelding 8). Het is hierbij belangrijk om te vermelden dat de authentication service, ondanks dat hij los staat van de backend, wel in de backend hoort. Deze hebben wij hier losgekoppeld om duidelijk de interactie aan te geven tussen de 'controller'/frontend en de authenticatie service.

![Component Diagram Authenticeren](/opdracht-diagrammen/C4-Diagrammen/ComponentDiagramMischa.png)
_Afbeelding 8: Component diagram authenticeren._

##### Dynamisch diagram
Dit dynamisch diagram toont de authenticatieflow binnen de Triptop applicatie (zie afbeelding 9). De gebruiker logt in via de frontend, die de inloggegevens doorstuurt naar de backend. De backend valideert deze gegevens via de Authentication Service, die op zijn beurt een externe authenticatie service aanroept. Na successvolle validatie wordt een token gegenereerd en teruggestuurd naar de gebruiker. Deze token wordt vervolgens gebruikt om (geauthenticeerde) verzoeken naar de externe API's te versturen. Net zoals bij het component diagram is het belangrijk om te vermelden dat authenticatie service, desondanks het los staat van de backend, bij de backend hoort. Ook hier is de reden dat wij het los hebben vermeld om duidelijker de interactie tussen de 'controller'/frontend en de authenticatie service aan te tonen.

![Dynamisch Diagram Authenticeren](/opdracht-diagrammen/C4-Diagrammen/DynamischDiagramMischa.png)
_Afbeelding 9: Dynamisch diagram authenticeren._

#### 7.3.2. Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen? (Jamiro)
Voor deze onderzoeksvraag hebben wij een Component diagram gemaakt. Om de onderzoeksvraag te beantwoorden hebben wij ervoor gekozen om het adapter pattern te volgen.

Het "Adapter pattern" houdt in dat er een "Adapter"-klasse is die tussen een externe service en de hoofdlogica van de applicatie zit.
Deze klasse formateert de data die naar de externe service wordt doorgestuurd, maar ook de data die wij opvragen van de externe service. 
Als de externe service iets verandert met de data die ze opsturen, of de data die ze opgestuurd willen krijgen. Kan je dit afvangen in de "Adapter"-klasse


Verdere uitleg voor waarom wij voor het "Adapter pattern" hebben gekozen wordt behandeld in 
[ADR-004](#84-adr-004-voor-exterene-apis-gebruiken-wij-de-adapter-pattern-)

##### Component diagram
![Component Diagram Adapter pattern](/opdracht-diagrammen/C4-Diagrammen/ComponentDiagramJamiro.png)
_Afbeelding 10: Component diagram Adapter pattern._

##### Dynamisch diagram
Dit dynamische diagram laat zien hoe een de gebruiker de details van een hotel binnen krijgt. 
Je kan hierin zien hoe de adapter wordt gebruikt en hoe de adapter een rol speelt in deze applicatie. 
![Dynamisch Component Diagram Adapter pattern](/opdracht-diagrammen/C4-Diagrammen/DynamischDiagramAdapterJamiro.png)
_Afbeelding 10: Sequence Diagram Adapter pattern._
### 7.4. Design & Code
#### 7.4.1. Hoe zorg je ervoor dat authenticatie en autorisatie consistent worden toegepast bij het communiceren met verschillende externe API's?
##### Klasse diagram
Wij hebben voor deze onderzoeksvraag een klasse diagram ontworpen (zie afbeelding 8) op basis van de eerder benoemde **strategy pattern**. Het is belangrijk om te vermelden dat we alleen hebben gefocust op het authenticeren. Dit is gedaan met de gedachten dat het autorisatie op dezelfde manier geïmplementeert kan worden als authenticatie met alleen de code in de functies zelf anders.

![Klasse Diagram Authenticeren](/opdracht-diagrammen/C4-Diagrammen/C4-Class-Diagram-Mischa.png)
_Afbeelding 11: Klasse diagram authenticeren._

#### Sequence diagram
Het sequence diagram laat duidelijk de interacties tussen de verschillende klasses zien tijdens het authenticeren (zie afbeelding 11). De gebruiker voert inloggegevens in via de frontend, waarna de Authentication Controller deze doorstuurt naar de Authentication Service. Afhankelijk van de gewenste authenticatiemethode (bijv. gebruikersnaam/wachtwoord, API-sleutel of geheime token), wordt een implementatie van authStrategy aangeroepen die de inloggegevens controleert. Bij een succesvolle inlog wordt er een token gegenereerd en teruggestuurd. Deze token kan vervolgens gebruikt worden voor geauthenticeerde verzoeken.

![Sequence Diagram Authenticeren](/opdracht-diagrammen/C4-Diagrammen/SequenceDiagramMischa.png)
_Afbeelding 12: Sequence diagram authenticeren._


#### 7.4.2. Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen? (Jamiro)
##### Klasse diagram
Voor deze onderzoeksvraag hebben wij een klassen diagram gemaakt met de adapter pattern. 
De reden hiervoor is dat als een API veranderingen maakt, dat je alleen de adapter hoeft aantepassen in plaats van de gehele applicatie.

![Klasse Diagram Adapter](/opdracht-diagrammen/C4-Diagrammen/C4-Class-Diagram-Jamiro-Triptop.png)
_Afbeelding 13: Klasse diagram adapter pattern._

#### Sequence diagram
Het sequence diagram laat zien waar de adapter klasse komt te staan en hoe deze gebruikt wordt.
Om duidelijkheid tussen de verschillende lagen te creëren heeft iedere laag ook net een andere methode naam.
De endpoint heet "getHotelDetail" want deze haalt natuurlijk de hoteldetails op.
In de service noemen we de methode "retrieveHotelDetails" omdat je de details gaat retrieven van de adapter klasse.
In de Adapter noemen we de methode "fetchHotelDetails" omdat je nu de details gaat fetchen van de externe Api.
De vraag teken bij de externe api staat er bewust. 
De reden hiervoor is omdat als je van API veranderd deze methode naam ook mee veranderd.
Voor nu hebben wij hem dus open gelaten.
En de responses die je krijgt worden steeds meer geformatteerd. 
Totdat het weer op de frontend aankomt en de gebruiker de data ziet.

![Sequence Diagram Adapter pattern](/opdracht-diagrammen/C4-Diagrammen/SquenceDiagramAdapterPatternJamiro.png)
_Afbeelding 14: Sequence Diagram Adapter pattern._

## 8. Architectural Decision Records
### 8.1. ADR-001 Het gebruik van postman voor prototypes
#### Status
Voorgesteld

#### Context 
Als groep hebben wij prototypes moeten maken voor de API's die wij benoemen in het containerdiagram/C4-diagrammen.
Als groep wouden wij een manier hebben hoe wij test's schreven voor de API's, Zodat we voorkomen dat de ene een hele Java-Applicatie gaat maken en de ander Postman gaat gebruiken. 

#### Overwogen opties
|                       | Beveiligingsopties | Mocking Functionaliteit | Samenwerking & Delen | Ondersteuning voor verschillende API's | 
|-----------------------|--------------------|-------------------------|----------------------|----------------------------------------|
| Postman               | ++                 | ++                      | ++                   | ++                                     |
| Eigen Java-Applicatie | *                  | *                       | *                    | *                                      |     

_Tabel 2: Overwogen opties prototypes._

##### Beveiligingsopties
- Postman ondersteunt OAuth, API keys, en certificaten direct.
- Een eigen Java-Applicatie kan dit ook, maar moet handmatig worden geïmplementeerd.

##### Mocking Functionaliteit
- Postman biedt mock servers om API-gedrag te simuleren.
- Een eigen Java-Applicatie vereist extra frameworks zoals WireMock.

##### Samenwerking & Delen 
- Postman maakt het makkelijk om API-requests en testcases te delen via workspaces.
- Een eigen Java-Applicatie vereist documentatie en code-reviews.

##### Ondersteuning voor verschillende API's
- Postman ondersteunt REST, SOAP, GraphQL, en WebSockets standaard.
- Een eigen Java-Applicatie vereist extra code en bibliotheken. 

#### Besluit
Wij hebben besloten om Postman te gebruiken.  
De reden hiervoor is dat iedereen in onze groep bekend is met Postman en dat het een snelle en eenvoudige manier biedt om te testen of endpoints werken.

#### Consequenties 
##### Positief
- In Postman kun je eenvoudig requests groeperen in een collectie. Dit zorgt voor meer overzicht, bijvoorbeeld door aparte collecties te maken voor hotels en vluchten.
- Postman biedt de mogelijkheid om een Workspace te gebruiken en te delen met het team, zodat iedereen met dezelfde requests werkt.

##### Neutraal
- Requests kunnen een naam krijgen, waardoor ze eenvoudig terug te vinden en te onderscheiden zijn.

##### Negatief
- Voor mensen die nog nooit met Postman hebben gewerkt, kan het in het begin onduidelijk zijn.
- Als Postman niet beschikbaar is, kunnen we de API's niet testen, omdat alles binnen Postman staat.
- Wij gebruiken de gratis versie van Postman, mocht het veranderen dat wij moeten betalen moeten wij overstappen naar een andere optie. 

### 8.2. ADR-002 Opslaan van JWT token
#### Status
Voorgesteld

#### Context
Voor de authenticatie en authorisatie in de software maken we gebruik van een externe API. Deze API geeft een token terug bij een succesvolle login die wij kunnen opslaan en versturen naar andere API's om aan te tonen dat het een geautoriseerde gebruiker is en wat zijn rechten zijn in de software. Er zijn verschillende mogelijkheden voor waar we deze token willen opslaan, elk met zijn eigen voor- en nadelen.

#### Overwogen opties

|                 | Veiligheid | Toegankelijkheid | Persistentie |
|-----------------|------------|------------------|--------------|
| Local Storage   | --         | ++               | --           |
| Session Storage | ++         | +                | ++           |

_Tabel 3: Overwogen opties JWT token._

Het is handig om te vermelden dat alhoewel we bedoelen met persistentie of dat de token bewaard blijft als de browser sluit is dit juist een nadeel. De plusjes betekenen dat dit niet wordt bewaard en de minnetjes dus dat het wel bewaard blijft.

##### Veiligheid
- **Local Storage**: Tokens opgeslagen in de local storage zijn kwetsbaarder voor XSS-aanvallen omdat ze toegankelijk zijn via JavaScript. Dit maakt het erg onveilig.
- **Session Storage**: Tokens opgeslagen in Session Storage zijn veiliger omdat ze alleen toegankelijk zijn binnen de sessie van de browser en worden verwijderd zodra de sessie eindigt. Dit maakt ze erg veilig.

##### Toegankelijkheid
- **Local Storage**: Tokens in local storage zijn gemakkelijk toegankelijk voor JavaScript en blijven beschikbaar tussen verschillende plekken op de website, wat de toegankelijkheid verhoogt.
- **Session Storage**: Tokens in session storage zijn alleen toegankelijk binnen de huidige sessie, en van zichzelf op dezelfde plek. Mocht je deze willen gebruiken op andere plekken op de website, zal je ze moeten doorsturen. Dit vermindert de toegankelijkheid wel.

##### Persistentie
- **Local Storage**: Tokens in local storage blijven bewaard zelfs als de browser wordt gesloten en opnieuw geopend, wat de persistentie verhoogt. Maar de veiligheid aanzienlijk vermindert.
- **Session Storage**: Tokens in session storage worden verwijderd zodra de browser of tabblad wordt gesloten. Dit betekent dat ze niet persistent zijn, maar daardoor wel een flink stuk veiliger.

#### Besluit
Wij gaan de JWT tokens opslaan in de session storage. Hier hebben wij voor gekozen sinds dit een veiligere optie is dan de Local Storage terwijl het niet veel minder toegankelijk is. Daarnaast hebben wij in het team ook meer kennis over session storage dan local storage.

#### Consequenties
##### Positief
- Verhoogde veiligheid doordat tokens niet toegankelijk zijn na het sluiten van de browser of het tabblad.
- Minder risico op XSS-aanvallen omdat tokens niet toegankelijk zijn via JavaScript buiten de sessie.

##### Neutraal
- Toegankelijkheid is iets verminderd, maar nog steeds voldoende voor de meeste gebruiksscenario's.
- Bekendheid en kennis binnen het team over session storage maakt implementatie eenvoudiger.

##### Negatief
- Tokens moeten opnieuw worden opgehaald na het sluiten en heropenen van de browser, wat een extra stap kan zijn voor de gebruiker.

### 8.3. ADR-003 BookingAPI wordt gebruikt voor hotels, vluchten en autoverhuur
#### Status
Niet meer van toepassing

#### Context
Wij zochten API's die wij konden gebruiken voor het zoeken van hotels, vluchten en autoverhuur.

#### Overwogen opties

|                 | Documentatie | Betrouwbaarheid | Schaalbaarheid | Api dekking |
|-----------------|--------------|-----------------|----------------|-------------|
| Booking.com     | ++           | ++              | ++             |             |
| Flights scraper | -            | -               | -              |             | 
| Priceline.com   | ++           | ++              | ++             |             | 
| TravelData      | +            | +               | +              |             |


_Tabel 3: ADR-003 Overwogen opties ._

Booking.com en Priceline.com bieden uitgebreide documentatie, zijn betrouwbaar en schaalbaar door hun grote gebruikersbasis. Flights scraper is vaak minder betrouwbaar en schaalbaar, afhankelijk van het scrapen van gegevens. TravelData heeft gemiddelde documentatie, betrouwbaarheid en schaalbaarheid.

#### Besluit
Wij hebben besloten om Booking.com te gebruiken voor het zoeken van hotels, vluchten en autoverhuur. Dit is omdat Booking.com uitgebreide documentatie biedt, betrouwbaar is en schaalbaar is door zijn grote gebruikersbasis en het is bekender binnen de team dan Priceline.com.

#### Consequenties
##### Positief
- Kan hierdoor veel in bij dezelfde API afhandelen


##### Negatief
- Mocht deze API ooit veranderen moeten we alles veranderen wat onder vluchten, hotels en auto verhuur valt.
- Mocht deze API ooit vervallen/out of business gaan, werkt veel van onze applicatie niet meer

### 8.4. ADR-004 Voor authenticeren en authoriseren gebruiken wij de strategy pattern
#### Status
Voorgesteld

#### Context
Bij de ontwerpvraag:

```Hoe zorg je ervoor dat authenticatie en autorisatie consistent worden toegepast bij het communiceren met verschillende externe API's?```

Hebben wij onderzocht hoe wij kunnen voorkomen dat wij consistent authenticatie en autorisatie kunnen toepassen bij de verschillende externe API's.

#### Overwogen opties

|                        	| Flexibiliteit 	| Onderhoudbaarheid 	| Complexiteit 	|
|------------------------	|---------------	|-------------------	|--------------	|
| State pattern          	| +             	| +                 	| --           	|
| Adapter pattern        	| +             	| ++                	| -            	|
| Strategy pattern       	| ++            	| ++                	| +            	|
| Facade pattern         	| -             	| +                 	| +            	|
| Factory method pattern 	| +             	| +                 	| -            	|

_Tabel 4: Overwogen opties authenticeren strategy._

##### Flexibiliteit
- **State pattern**: Kan nuttig zijn voor toestandsafhankelijke authenticatie en autorisatie, maar is minder geschikt voor het toepassen van verschillende authenticatie- en autorisatiestrategieën.
- **Adapter pattern**: Zorgt voor compatibiliteit tussen verschillende API-authenticatie- en autorisatiemethoden, maar biedt minder flexibiliteit in strategieën.
- **Strategy pattern**: Biedt hoge flexibiliteit doordat verschillende authenticatie- en autorisatiestrategieën eenvoudig verwisselbaar zijn.
- **Facade pattern**: Vereenvoudigt de toegang tot authenticatie en autorisatie, maar beperkt de flexibiliteit.

##### Onderhoudbaarheid
- **State pattern**: Code blijft redelijk onderhoudbaar, maar kan complex worden bij veel toestanden.
- **Adapter pattern**: Hoge onderhoudbaarheid doordat het bestaande implementaties hergebruikt zonder deze te wijzigen.
- **Strategy pattern**: Hoge onderhoudbaarheid doordat strategieën los van elkaar ontwikkeld en aangepast kunnen worden.
- **Facade pattern**: Code blijft overzichtelijk, maar aanpassingen aan de onderliggende implementatie kunnen impact hebben op de gehele interface.
- **Factory method**: Maakt het makkelijk om nieuwe strategieën toe te voegen, maar is minder gestructureerd dan het strategy pattern.

##### Complexiteit
- **State pattern**: Hoge complexiteit bij meerdere authenticatie- en autorisatietoestanden.
- **Adapter pattern**: Lage complexiteit, maar minder krachtig voor het wisselen van strategieën.
- **Strategy pattern**: Gematigde complexiteit, maar de beste balans tussen flexibiliteit en onderhoudbaarheid.
- **Facade pattern**: Lage complexiteit, maar beperkt in functionaliteit.
- **Factory method**: Lage tot gematigde complexiteit, afhankelijk van het aantal gecreëerde objecten.

#### Besluit
Wij hebben gekozen voor het **strategy pattern**. Dit patroon maakt het eenvoudig om verschillende authenticatie- en autorisatiestrategieën te definiëren en toe te passen zonder hiervoor de andere code te moeten wijzigen. Hierdoor kunnen we makkelijk communiceren met meerdere externe API's door hiervoor de juiste authenticatie- en autorisatiemethode aan te roepen.

#### Consequenties
##### Positief
- Hoge flexibiliteit zorgt ervoor dat we eenvoudig verschillende authenticatie- en autorisatiestrategieën kunnen implementeren.
- Code blijft overzichtelijk en goed onderhoudbaar.
- Nieuwe authenticatie- en autorisatiemethoden kunnen gemakkelijk worden toegevoegd zonder de bestaande code te wijzigen.

##### Neutraal
- Initieel iets meer werk om het strategy pattern op te zetten, maar dit compenseert met de uitbreidbaarheid.

##### Negatief
- Meer afzonderlijke klassen en interfaces, wat het aantal klassen vergroot.
- Ontwikkelaars moeten bekend zijn met het strategy pattern om de implementatie ervan goed te begrijpen en te gebruiken.

### 8.5. ADR-005 Voor exterene Api's gebruiken wij de adapter pattern 
#### Status
Voorgesteld

#### Context
Bij de ontwerpvraag: 

```Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?```

Hebben wij onderzocht hoe wij kunnen voorkomen dat wij de gehele applicatie zouden moeten aanpassen als een externe service wordt aangepast.

#### Overwogen opties
- State pattern
- Adapter pattern
- Strategy pattern
- Facade pattern
- Factory method

##### State pattern
Laat een object zijn gedrag veranderen afhankelijk van zijn interne toestand.
##### Adapter pattern
Maakt het mogelijk om twee incompatible interfaces met elkaar te laten samenwerken zonder bestaande code te wijzigen.
##### Strategy pattern
Defineerd een familie van algoritmen en maakt ze onderling verwisselbaar zonder de code ze gebruikt te veranderen.
##### Facade pattern
Vereenvoudigt een complex systeem door een enkele, gebruiksvriendelijk interface aan te bieden.
##### Factory method pattern
Biedt een manier om objecten te maken zonder expliciet de exacte klasse van het te maken object te specificeren.

#### Besluit
Na ons onderzoek bleek het *__Adapter Pattern__* de beste keuze te zijn.
We hebben hiervoor gekozen. 
Omdat een adapter het mogelijk maakt om wijzigingen in de externe API of een overstap naar een andere provider eenvoudig door te voeren.
Dit vereist alleen aanpassingen in één klasse.
Dit minimaliseert de impact op de rest van de applicatie en maakt onderhoud eenvoudiger.
Dit beantwoordt ook de ontwerpvraag.

#### Consequenties
##### Positief
- Decoupling, De hoofdlogica van de applicatie blijft onafhankelijk van externe API's of systemen
- Eenvoudig van externe API's en systemen wisselen
- Je kan de adapter mocken waardoor je beter kan testen

##### Neutraal
- Extra code nodig 
- Kan overkill zijn als een API nooit verandert
##### Negatief
- Door de extra "Adapter" laag wordt de applicatie complexer
- Door het extra formateren en transformeren van data kan dit zorgen voor een kleine vertraging


### 8.6. ADR-006 Herziening van ADR-003 - Minder afhankelijkheid van Booking.com
#### Status
Voorgesteld

#### Context
Bij [ADR-003](#83-adr-003-bookingapi-wordt-gebruikt-voor-hotels-vluchten-en-autoverhuur)
wouden wij het besluit maken om de booking.com api te gebruiken voor hotels, vluchten en autoverhuur.
Als groep gaan wij hier van af zien. De reden hiervoor is als deze API er uit ligt. 3 groten delen van onze applicatie niet meer werkt

Het idee is dus dat wij niet geheel of grotendeels afhankelijk willen zijn van 1 API. 
De regel die wij willen hanteren is dat een API maar voor 1 onderdeel gebruikt mag worden. Voorbeeld: Booking.com regels alles voor Hotels.
Je mag hotels ophalen boeken ect. Maar je mag Booking.com niet gebruiken voor vluchten of auto verhuur.

#### Overwogen opties
- Veel afhankelijkheden van dezelfde API
- Weinig afhankelijkheid van een API

#### Besluit
Wij kiezen ervoor om zo min mogelijk afhankelijk te zijn van één enkele API. 
Het doel is om te voorkomen dat de applicatie grotendeels niet meer werkt wanneer één API uitvalt of volledig verdwijnt.
Hoewel het nooit mogelijk is om te garanderen dat een API altijd beschikbaar blijft, kunnen we de risico’s beperken door meerdere API's te gebruiken voor verschillende doeleinden.

#### Consequenties
##### Positief
- Als een API niet werkt, ligt niet heel de applicatie plat

##### Negatief
- Hiervoor moeten wij wel veel herschrijven/opnieuw doen

### 8.7. ADR-007 Voorkeur voor externe api communicatie met authenticatie
#### Status
Voorgesteld

#### Context
Wij zochten manieren hoe wij volgens ons het beste kunnen communiceren met een externe IdentityProvider. De drie opties waar wij uit konden kiezen waren:
- Vanuit de frontend direct communiceren met de IdentityProvider
- Vanuit de frontend met een eigen backend communiceren die vervolgens met de IdentityProvider communiceert
- Een hybride oplossing waarbij de frontend en backend beide communiceren met de IdentityProvider

#### Overwogen opties
- Directe communicatie vanuit de frontend
    - Voordelen: Snel, geen extra laag
    - Nadelen: Minder veilig, minder controle
- Communicatie via een eigen backend
    - Voordelen: Meer controle, veiliger
    - Nadelen: Langzamer, extra laag
- Hybride oplossing
    - Voordelen: Controle, snelheid
    - Nadelen: Complexer, extra laag

#### Besluit
Wij hebben uiteindelijk besloten om niet de externe IdentityProvider direct vanuit de frontend te benaderen, maar wel om een eigen backend te gebruiken die vervolgens met de IdentityProvider communiceert.

#### Consequenties
Positief
- Verhoogde veiligheid doordat de backend de communicatie met de IdentityProvider afhandelt.
- Meer controle over de authenticatie- en autorisatieprocessen.
- Backend kan extra validaties en logging toevoegen voor betere monitoring.

Neutraal
- Extra laag in de architectuur kan de complexiteit verhogen, maar biedt ook meer flexibiliteit.

##### Negatief
- Mogelijk langzamere prestaties door de extra communicatielaag.
- Meer onderhoud nodig voor de backend code die de communicatie afhandelt.

## 9. Deployment, Operation and Support
> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.