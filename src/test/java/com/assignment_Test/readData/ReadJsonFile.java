package com.assignment_Test.readData;

import com.assignment_Test.pojo.Temperature_Inputs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.DataInput;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReadJsonFile {
    /**
     * We can collect all the data from the Json file into a List of POJO objects
     * and then loop through the list and assert each one
     */

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            //Single Pojo
            System.out.println("************************************************");
            Temperature_Inputs t1 = mapper.readValue(Paths.get("src/test/resources/data/Temperature_Inputs.json").toFile(), Temperature_Inputs.class);
            System.out.println(t1);
            System.out.println("***********************************************");

            //**********************************************************************************************************
            //All The Objects in a given Json Array
            //Create a node from the file.
            JsonNode node = mapper.readTree(Paths.get("src/test/resources/data/Temperature_Inputs.json").toFile());
            List<Temperature_Inputs> temperatureInputTestCaseList = new LinkedList<>();
            //GET INSIDE THE ARRAY OF OBJECTS that you want to get a list of.
            JsonNode arrayOfTestCases = node.get("testcases");
            for (JsonNode eachTestCase : arrayOfTestCases) {
                String nodeContent = mapper.writeValueAsString(eachTestCase);
                temperatureInputTestCaseList.add(mapper.readValue(nodeContent, Temperature_Inputs.class));
            }
            System.out.println(temperatureInputTestCaseList);
            System.out.println(arrayOfTestCases.size());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
