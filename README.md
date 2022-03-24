# e-Ticketing-Platform

Stage I
1) System definition
Create a list based on the chosen theme with at least 10 actions/queries that can be done in
within the system and a list of at least 8 object types.
  - [ ] 10 actions/queries
  - [x] 8 object types
 
2) Implementation
Implement an application based on the ones defined in the first step in the Java language.
The application will contain:
  - [x] simple classes with private/protected attributes and access methods
  - [ ] at least 2 different collections capable of handling the objects defined above (eg: List, Set,
Map, etc.) of which at least one must be sorted - uni- arrays will be used.
/bidimensional arrays in case the collections are not browsed until the checkpoint date.
  - [ ] use inheritance to create additional classes and use them within collections;
  - [ ] at least one service class to expose system operations
  - [ ] a Main class from which calls to services are made

Stage II
1) Extend the project from the first stage by making persistence using files:
  - [ ] Make CSV files for at least 4 of the classes defined in the first stage. Each column in the file is separated by comma. Example: first name, last name, age
  - [ ] Generic singleton services will be created for writing and reading from files;
  - [ ] When starting the program, the data from the files will be loaded using the services created;

2) Creation of an audit service
  - [ ] A service will be created to write to a CSV file each time one of the actions described in the first step is executed. File structure: action_name, timestamp

Step III
  - [ ] Replace the services made in step II with services that provide persistence using JDBC.
  - [ ] Make services that expose create, read, update and delete operations for at least 4 of the defined classes.
