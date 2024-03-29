# e-Ticketing-Platform-PAO


The project involves a CLI e-ticketing platform that allows users to purchase event tickets. Administrators are able to manage events, sponsors, and user accounts. The app also includes CSV file persistence for data. In later stages, it introduces JDBC for database persistence and adds auditing functionality.
  
  I attached a txt file with some example inputs to make testing easier. The admin has a "change" method which switches from an "admin" account to a "client" one for testing purposes. To log in as a user (after creating one as an admin), enter "tempPassword" as password.
  I attached a txt file in stage1 branch with some example inputs to make testing easier. The admin has a "change" method which switches from an "admin" account to a "client" one for testing purposes. To log in as a user (after creating one as an admin), enter "tempPassword" as password.
  
Stage I
1) System definition
Create a list based on the chosen theme with at least 10 actions/queries that can be done in
within the system and a list of at least 8 object types.
  - [x] 10 actions/queries:
      - ADMIN: *createClient, createFootballGameEvent, createConcertEvent, createMovieEvent, createSponsor, updateClient, updateFootballGameEvent, updateConcertEvent, updateMovieEvent, updateSponsor, getEvents, getClients, getSponsors, getSponsorsByType, deleteEvent, deleteClient, deleteSponsor, addSponsorToEvent, buyTicket, change, exit*
      - CLIENT: *getInfo, changePassword, getEvents, getSponsors, getSponsorsByType, buyTicket, exit*
  - [x] 8 object types
      - POJOs: *Client, Event, CulturalEvent, Movie, Concert, SportEvent, FootballGame, Sponsor, Location, Ticket*
      - Services: *ClientService, EventService, SponsorService, LocationService, TicketService*
2) Implementation
Implement an application based on the ones defined in the first step in the Java language.
The application will contain:
  - [x] simple classes with private/protected attributes and access methods
  - [x] at least 2 different collections capable of handling the objects defined above (eg: List, Set,
Map, etc.) of which at least one must be sorted - uni- arrays will be used.
/bidimensional arrays in case the collections are not browsed until the checkpoint date.
      - TreeSet<Sponsor>(new SponsorComparator())  -> sorted by type: gold, silver, bronze
      - ArrayLists
  - [x] use inheritance to create additional classes and use them within collections;
      - *Event ->(CulturalEvent -> Movie, Concert; SportEvent -> FootballGame)*
  - [x] at least one service class to expose system operations
      - *ClientService, EventService, LocationService, SponsorService, TicketService*
  - [x] a Main class from which calls to services are made

Stage II
1) Extend the project from the first stage by making persistence using files:
  - [x] Make CSV files for at least 4 of the classes defined in the first stage. Each column in the file is separated by comma. Example: first name, last name, age
      - *audit.csv, client.csv, concert.csv, footballgame.csv, movie.csv, sponsor.csv*
  - [x] Generic singleton services will be created for writing and reading from files;
      - *ReadService, WriteService*
  - [x] When starting the program, the data from the files will be loaded using the services created;

2) Creation of an audit service
  - [x] A service will be created to write to a CSV file each time one of the actions described in the first step is executed. File structure: action_name, timestamp
      - *AuditService*
      
Stage III
  - [x] Replace the services made in step II with services that provide persistence using JDBC.
  - [x] Make services that expose create, read, update and delete operations for at least 4 of the defined classes.
