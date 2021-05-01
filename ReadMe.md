# Test Engineer Challenge - Temperature Converter

This repository contains a maven framework that has:
  
## Main Package 
* This is where the actual code for the converter is

## Test Package 
* This is where a BDD framework is setup to test and assert the code found in the Main package.
```
  >Features Package 
  - contains my feature file with my Scenario Outline.
    - here more positive and negative test cases and/or edge cases can be added in the Examples Table.

  >Step_Definitions Package 
  - contains my implementations for my Scenario Outline once I do a dryrun of it.

  >Runners Package
     -> CukesRunner - main runner for my BDD framework. Will run all scenarios or the ones that have certain tags. 
        
     -> FailedRunner - runs only the failed tests that it finds in the rerun.txt file
```
## Reports
* Using maven-sure-plugin we can get html reports generated from a 'cucumber.json' file that we add in our @CucumberOptions in our CukesRunner
```xml
          <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <!--1 feature file per thread. Control the amount of max threads here-->
                    <parallel>methods</parallel>
                    <threadCount> 6 </threadCount>
                    <perCoreThreadCount>false</perCoreThreadCount>

                    <!-- If one of my tests fails then continue with that execution -->
                    <testFailureIgnore>true</testFailureIgnore>
                    <includes>
                        <include>**/CukesRunner*.java</include>
                    </includes>
                </configuration>
            </plugin>
```

## CI/CD Integration
Amazon EC2:
* Linux AMI with Docker and Jenkins
  *    
