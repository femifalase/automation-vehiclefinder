# test-vehiclefinder Automation Project

This is a test automation project for finding Vehicle details online.

- The Test Junit runner classes: .\src\test\java\runners

   - AllCSVTest.java :- Running directory scanner to list all CSV files in a directory. default location: .\files
   - AllDirectoryDocsTest :- Running directory scanner to list all files types in a directory. default location: .\files
   - AllExcelTestTest :- Running directory scanner to list all Excel files in a directory. default location: .\files
   - CucumberVehicleTest :- Running BDD cucumber tests.
      - After running the cumcumber tests, the reports and screenshots will be generated to the maven target folder:  .\target\reports
   - SeleniumVehicleTest :- Running direct selenium tests. 
   
- Design patterns used:

   - Singleton pattern for Webdriver (Driver) class
   - Page Object Model
           

