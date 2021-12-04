## Flink Automation Framework
The framework is for the Workmotion-

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
What things you need to install the software and how to install them
```
Maven
Java
Eclipse/IntelliJ
```

## Steps to execute the framework in your local


1. Checkout the code in your local using: 
    **<Git hub repo is shared via email>**
2. Once checked out, import the project as "maven project" in eclipse/STS/IntelliJ
3. Once import is successfully, you can run pom.xml
4. In order to run demo E2E tests suite files or feature-wise suite file(s) for a particular component manually.
        - `mvn.cmd clean install -Dbrowser=<browser>  -Dfeature=<testrunner>


<b>Eg:</b> `mvn.cmd clean install -Dbrowser=firefox -Dfeature=AllFields


<h3><b>Note:</b></h3>


*  Values for the parameters passed when running from maven commandline:

    | **Parameter Name** | **Description** | **Values** |
    | ------ | ------ | ------ |
    | browser | Which browser to run test on | chrome/firefox |
    | feature | Which feature file to trigger | AllFields/Optional |


<b>Note:</b> Drivers will be automatically taken care of. No driver as a pre-requisite is needed.</font>


## Project Structure
As the project is maven based, have followed 'standard' maven project structure as below:

```
src/main/java       - Consists of Page classes & methods
src/main/resources  - Consists of resources utilised by across (such as log4j.properties, setup.properties etc.)   
src/main/test       - Consists of tests to be executed
src/main/resources  - Consists of test data which is required for the tests to run
/TestReport         - Consists of reports & logs files for tests
```

## Built With
* Dependency Management - [Maven](https://maven.apache.org/)  
* Web framework used    - Selenium WebDriver + PageFactory Model
* Testing tool          - [TestNG](https://testng.org/doc/)
* Logging               - [Log4J](https://logging.apache.org/log4j/2.x/)

## IMPORTANT POINTS
1. The framework is platform and browser independent. But the tests have been run on Chrome and Windows.
2. The framework is suitable to integrate into the pipeline.
3. There are many other combinations possible that could be added to this suite, but only limited have been taken care of for the task purpose. 
4. There are some limitations in the application as well as in the code. In the action items, there is no list (web element) available that can be iterated over, so in order to pass the test, there should be only one "Pending" entry to get the element.
5. In code, at few places hard coded sleep is used, because application does not respond at those particular places on the conditional waits.
6. If any special change is needed, I would be happy to do so.
7. The framework is data driven and all the data and dependencies have been taken care of automatically. Simply run the maven command and all the tests will be executed automatically.
