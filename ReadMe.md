# Test Engineer Challenge - Temperature Converter

This repository contains a maven framework that has:
  
## Main Package 
* This is where the actual code for the converter is

## Test Package 
* This is where a BDD framework is setup to test and assert the code found in the Main package.
```
  >Features Package<
  - contains the feature file with a Scenario Outline for this task. Written in Gherkin language.
    - here more positive and negative test cases and/or edge cases can be added in the Examples Table.

  >Step_Definitions Package<
  - contains implementations for the Scenario Outline. After running a failed test using dryrun in our CukesRunner getting an MVP we being to give implementation to each step. 

  >Runners Package<
     -> CukesRunner - main runner for this BDD framework. Will run all scenarios or the ones that have certain tags. In this case we have tagged our scenario outline with the @regression tag 
        
     -> FailedRunner - runs only the failed tests that it finds in the rerun.txt file. The features path is directed to the rerun.txt file.
```
## Reports
* Using maven-cucumber-reporting we can get html reports generated from a 'cucumber.json' file. A plugin placed in @CucumberOptions in our CukesRunner allows us to generate the 'cucumber.json' file
```xml
          <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>5.4.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>Cucumber HTML Reports</projectName>
                            <outputDirectory>${project.build.directory}</outputDirectory>
                            <inputDirectory>${project.build.directory}</inputDirectory>
                            <jsonFiles>
                                <param>**/cucumber*.json</param>
                            </jsonFiles>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

## CI/CD Integration
Amazon EC2:
* Linux AMI with Docker and Jenkins installed on it.
  *  Access to Jenkins: [Link to Jenkins](http://100.26.236.242:8080/)
      * Username: admin
      * Password: admin   
