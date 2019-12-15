Before executing the project find the below things for better understanding:

1. Programming Language - JAVA.

2. Tools - Selenium.

3. Framework - Cucumber BDD Framework.

4. Reporting tool - Extent Report.

5. Logging - Log4J 

=======================================================================================

Pre-requisites

1. Java Version 1.8 and also the Environment Variable settings

2. Maven 3.5.4 and higher

3. Chrome latest version 79.0.3945.79

4. Mozilla Firefox latest version 71.0 (64-bit)

========================================================================================
Framework Execution:

Both GUI and API tests are integrated into single framework

1. Steps to run the automation framework.

   Option 1 - Eclipse
   
   1. Clone my Maven project from the GIT Repository and store it in a folder.
   2. Open the Eclipse and import using the option existing maven project.
   3. Make sure cucumber and TestNG plugins are installed.
   4. Navigate to the folder src/test/java and module.test.framework and then to Runner class.
   5. Right click and run as TestNG Test.
   6. The execution begins and enjoy the end to end case by default in Chrome browser
   7. HTML Reports are found under output folder after completing the execution.
   8. Screen shots for success and Failure transactions are present under screnshots folder.


   Option 2 - Command prompt
   
   To run through command prompt please find the below steps:
   1. Open the command prompt 
   2. Navigate to the project directory where POM.xml exists cd "project path"
   3. Type mvn test and hit enter.
   4. Test execution begins in default Chrome browser and perform success and failure transaction of GUI and API.
   5. Once the execution is completed. The results are present under output folder named as report.html
   6. Screen shots are captured for both Success and Failure scenario and are present under screenshot folder inside the project.


Note: 1. To Run in Mozilla change the Browser from Chrome to Mozilla in Config Property file.
      2. API Results can be seen in the console.

========================================================================================

