###Labregister Inventory Management HLD-1
![](com-labregister-inventory/app-doc/HLD-1.png)
#### Pre-requisite:
-	JAVA 8
-	Maven
-	My Sql Server Service should be up and running
-	Postman {Any Tool will work for rest api testing}
-	Git 
#### Steps to Make the Labregister Inventory Application up and running:
-	##### Git clone from the below url in local system.
    url: https://github.com/novice-manu/com-labregister-inventory.git
-	##### Database Setup:
    -	In Local Instance of MySQL create a schema name “labregister_local” and set it as default schema.
    -	Open MySQL Workbench->Server->Data Import.
    -	Go into dumps folder in the project cloned above to get the dump files to setup the database schema and populate default data.
    Hint: \com-labregister-inventory\src\main\resources\db-scripts\dumps 
    -	Verification: in left panel should be able to see 2 tables under
    labregister_local schema. The Database setup is done.
-	##### Application Compile and build
    Open your favorite Terminal and run below commands.
	go to root directory of the project which is cloned from the git
```sh
mvn clean install
```
```sh
mvn spring-boot:run
```
 -	##### Application Test Using Postman:
     Got to Postman >> Import >> Upload Files >> browse api-test folder of the project and import the .json file.
    Hint: D:\labforward-assignment\com-labregister-inventory\src\main\resources\api-test.
    Sample Request for 4 endpoints will be imported. To check the end-to-end connectivity from postman>>app>>database try hitting the Get Items by Category API.
    If you get the below response, then the app is configured successfully.

 

