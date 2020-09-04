# Basic Spring to Redis conenction
<!-- UL -->
* Basic code using spring boot and Java ( 1.8 or above)


### Build With
<!-- UL -->
[Java 1.8 or above] - Java Platform, Standard Edition Development Kit <br> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html <br>
[ Eclipse ] - Java Integrated Development Environment ( IDE )<br> https://www.eclipse.org/downloads/ <br>
[ Maven 3.x] - Dependency Management perform uniform build system <br> https://maven.apache.org/index.html <br>
[ Git ] - Free and Open source distributed version control system <br> https://git-scm.com/ <br>
[ Postman ] - API Development Environment ( local testing) <br> https://www.postman.com/



### SETUP Before Start for Windows System
<!-- UL -->

* 1) https://github.com/MicrosoftArchive/redis

Redis on Windows OS
This is a port for Windows based on Redis.
We officially support the 64-bit version only. Although you can build the 32-bit version from source if desired.
You can download the latest unsigned binaries and the unsigned MSI installer from the release page.

2) https://github.com/microsoftarchive/redis/releases

3) down load Redis-x64-3.0.504.zip and extract zip 
4) click on redis-server.exe to start server and 
    4.1) Second redis-cli.exe for Client ( at Client enter ping, you will get response as PONG )

### CMD commands to check is values stored at Redis
127.0.0.1:6379> keys *
1) "\xac\xed\x00\x05t\x00\bEmployee"
2) "name"
127.0.0.1:6379>
 
 
### Running the application locally
---
<!-- OL -->
1. Download the zip and unzip at project development folder
2. Open eclipse <br>
  2.1 - File import as existing Maven project
  2.2 - Navigate up to folder POM.xml for maven dependencies
  2.3 - Search file Application with @SpringBootApplication annotation as main starting file
  2.4 - Right click and run as java application   
3. Check console log as project run at Tomcat server on port 8080
4. The application will run at http://localhost:8080 or check http://localhost:8080/actuator/health
5. Application flow architecture 
<!-- UL -->


http://localhost:8080/redis
POST Method
{
    "id": 12345,
    "firstName": "Don",
    "lastName":"Johnson"    
}

GET Method
http://localhost:8080/redis/2345

