package com.assignment_Test.readData;

import com.assignment_Test.pojo.Temperature_Inputs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ReadJsonFile {
    /**
     * We can collect all the data from the Json file into a List of POJO objects
     * and then loop through the list and assert each one
     */

    public static List<Temperature_Inputs> temperatureInputTestCaseList = new LinkedList<>();

    public static void populate_ListOfTemperatureInputs(){
        try {
            ObjectMapper mapper = new ObjectMapper();

            //**********************************************************************************************************
            //All The Objects in a given Json Array
            //Create a node from the file.
            JsonNode node = mapper.readTree(Paths.get("src/test/resources/data/Temperature_Inputs.json").toFile());

            //GET INSIDE THE ARRAY OF OBJECTS that you want to get a list of.
            JsonNode arrayOfTestCases = node.get("testcases");
            for (JsonNode eachTestCase : arrayOfTestCases) {
                String nodeContent = mapper.writeValueAsString(eachTestCase);
                temperatureInputTestCaseList.add(mapper.readValue(nodeContent, Temperature_Inputs.class));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
