## Flink Automation Framework
The framework is for the Flink task-

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
    **<Git hub repo is shared and is not public>**
2. Once checked out, import the project as "maven project" in eclipse/STS/IntelliJ
3. Once import is sucessfully, you can run pom.xml
4. In order to run demo E2E tests suite files or feature-wise suite file(s) for a particular component manually.
        - `mvn.cmd clean install -Dbrowser=<browser>  -Dfeature=readerMode


<b>Eg:</b> `mvn.cmd clean install -Dbrowser=firefox -Dfeature=readerMode


<h3><b>Note:</b></h3>


*  Values for the parameters passed when running from maven commandline:

    | **Parameter Name** | **Description** | **Values** |
    | ------ | ------ | ------ |
    | browser | Which browser to run test on | chrome/firefox |
    | feature | Which feature file to trigger | readerMode/editorMode |


<b>Note:</b> Drivers are also included in the project. It will be automatically taken care of.</font>


## Project Structure
As the project is maven based, have followed 'standard' maven project structure as below:

```
src/main/java       - Consists of Page classes & methods
src/main/resources  - Consists of resources utilised by across (such as log4j.properties, setup.properties etc.)   
src/main/test       - Consists of tests to be executed
src/main/resources  - Consists of test data which is required for the tests to run
/TestReport         - Consists of reports & logs files for both UI & API tests
```

## Built With
* Dependency Management - [Maven](https://maven.apache.org/)  
* Web framework used    - Selenium WebDriver + PageFactory Model
* Testing tool          - [TestNG](https://testng.org/doc/)
* Logging               - [Log4J](https://logging.apache.org/log4j/2.x/)

	