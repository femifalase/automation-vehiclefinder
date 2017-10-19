# test-vehiclefinder Automation Project

This is a test automation project for finding Vehicle details online.

- Browsers configured: (Configuration can be changed inside .\src\main\resources\config.properties)
   - Firefox (Default)
   - Chrome
   - IE

- Junit Test runner classes: .\src\test\java\runners
   - AllCSVTest.java :- Running directory scanner to list all CSV files in a directory. default location: .\files
   - AllDirectoryDocsTest :- Running directory scanner to list all files types in a directory. default location: .\files
   - AllExcelTestTest :- Running directory scanner to list all Excel files in a directory. default location: .\files
   - CucumberVehicleTest :- Running BDD cucumber tests.
      - After running the cumcumber tests, the reports and screenshots will be generated to the maven target folder:  .\target\reports
   - SeleniumVehicleTest :- Running direct selenium tests. 
   
- Design patterns used:
   - Singleton pattern for Webdriver (Driver) class
   - Page Object Model
           
- Logging Framework used: Log4J

- Assertions Library used: Hamcrest 

- Dependency Injection used: Picocontainer

- Apache POI Library for excel reading

- Cucumber Java 8 (Stepdefinitions in Lambda)
