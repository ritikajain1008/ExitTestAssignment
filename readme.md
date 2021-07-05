###REDBUS SITE TESTING AUTOMATION FRAMEWORK
- A testing framework where all test cases are written using java language.
- A Maven project which follows page object model.
- A project is build using selenium & testng.

***

[URL of Testing website](https://www.redbus.in/)

***

####Tools Required:
- Eclipse-Workspace

***

####Files,Folders & Packages used in this project:
**src/main/java :**
- This folder consist of one package named as **com.redbus.pages**.

**com.redbus.pages :**
- This package consists of page classes used to locate elements & perform actions.
- It consists of 5 pages:-
  * BusHirePage.java
  * BusTicketsPage.java
  * HomePageFunctionality.java
  * LoginPage.java
  * RPoolFunctionality.java
  
***
  
**src/test/java :**
- This folder consists of two packages named as **com.redbus.tests** and **com.redbus.utils**.

**com.redbus.tests :**
- This package consists of test classes which comprises of intilaize browser, close browser & testcases.
- It consists of 6 test classes:-

Below classes consists of testcases:
  * BusHireTest.java
  * BusTicketTest.java
  * HomePageFunctionality.java
  * LoginTest.java
  * RPoolFunctionalityTest.java
  
Below class consists of setup browser,close browser as well as methods for generating reports  where Reports will be generated under Reports folder:
  * BaseTest.java
  
**com.redbus.utils :** 
- This package consists of utility classes.

**CommonUtils.java :**
- It consists of common methods used in most of test classes.

**DockerRunnable.java :**
- It consists of code to run testcases using docker.

**ExcelUtilities.java :**
- It consists of code to handle data from excel sheets.
 
**Screenshot.java :**
 - It consists of code to take screenshot in case of any testcase failure. Screenshots will be generated under screenshots folder.
 
***

**src/main/resources :**
- This folder consists of log4j.properties file used to log the info. loginfo will be generated on console as well as in file under Logs folder.

***

**Drivers: **
- This folder consists of chromedriver.exe(for chrome), geckodriver.exe(for firefox) & IEDriverServer.exe(for IE).
  
***

**ExcelSheets :**
- This folder comprises of two sheets named as testData1.xlsx & testData.xlsx.
- testData1.xlsx used to store whether execution req or not for a particular testcase.
- testData2.xlsx used to store test data for a test case.

***

**Resources :**
- This folder comprises of config.properties file used to set browser, mode or testdata for some testcases. If want to run testcases using docker then type 'yes' otherwise 'no' is written & for headless mode type headless.

***

**docker-compose.yml :**
- This file comprises of code so that number of testcases can be run on different ports of same browser at the same time.

***

**pom.xml :**
- This file comprises of dependencies.

***

**testng.xml :**
- This file is used to run all test suites parallely.

***

###Steps to run project:

***Project can be run from testng, cmd, docker, jenkins.***

**Run Project From TestNg: **
- Individual tests can be run from clicking run annotations under each test case.
- All Test Cases can be run at the same time by just right click run as testNg suite.

**Run Project From cmd: **
- Command used to run testcases from cmd is mvn clean install.

**Run Project From Docker: **
- Firstly install docker & do setup for it.
- Then command will run using cmd.
- Firstly an image for chrome or firefox is created using command - docker pull selenium/standalone-chrome(for chrome)
- Then to check whther an image is created or not using command- docker images.
- Then to run chrome container type - docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
- Then test cases can be run using docker by adding code for setting up the container.
- To run parallel test cases, type - docker-compose up in cmd where the docker-compose.yml file is located.
- To increase the number of chrome images type - docker-compose scale chrome = Number (Number = no.of images req)
- Then run all test cases parallely by right clicking on run as testng in eclipse.

**Run Project From Jenkins: **
- Firstly download jenkins.war file.
- Then cmd to the location of war file & type - java -jar jenkins.war --httpPort=8081
- Do required setup for project & give location of pom.xml file of it.
- Then run & test result report is generated which is also attached as a screenshot in wordfile in this project.

***

**GitHub Repository URL :**

[GitHub Repo URL]()




  
  
   