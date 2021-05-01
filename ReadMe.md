# Test Engineer Challenge - Temperature Converter

This repository contains a maven framework that has:
  
## Main Package 
\* This is where the actual code for the converter is

## Test Package 
\* This is where a BDD framework is setup to test and assert the code found in the Main package.

  ### >Features Package 
  - contains my feature file with my Scenario Outline.
    - here more positive and negative test cases and/or edge cases can be added in the Examples Table.
  
  ### >Step_Definitions Package 
  - contains my implementations for my Scenario Outline once I do a dryrun of it.
  
  ### >Runners Package
        -> CukesRunner - main runner for my BDD framework. Will run all scenarios or the ones that have certain tags. 
        
        -> FailedRunner - runs only the failed tests that it finds in the rerun.txt file
      
## CI/CD Integration
