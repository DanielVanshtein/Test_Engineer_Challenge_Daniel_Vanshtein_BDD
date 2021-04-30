package com.assignment_Dev;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Temperature_Converter_Main {

    public static void main(String[] args) {

        System.out.println("convert_Temperature(84.2, \"Fahrenheit\", \"Rankine\", \"543.94\") = " + convert_Temperature(84.2, "Fahrenheit", "Rankine", "543.87"));
        System.out.println("convert_Temperature(317.33, \"Kelvin\", \"Fahrenheit\", \"111.554\") = " + convert_Temperature(317.33, "Kelvin", "Fahrenheit", "111.554"));
        System.out.println("convert_Temperature(6.5, \"Fahrenheit\", \"Rankine\", \"dog\") = " + convert_Temperature(6.5, "Fahrenheit", "Rankine", "dog"));
        System.out.println("convert_Temperature(317.33, \"dogcow\", \"Celsius\", \"45.32\") = " + convert_Temperature(317.33, "dogcow", "Celsius", "45.32"));


        final DecimalFormat df1 = new DecimalFormat("0.0");
        System.out.println("df1.format(543.87) = " + df1.format(543.87));
        System.out.println(Double.parseDouble(df1.format(84.2 + 459.67)));

    }

    //if(!response.matches("^\\d+\\.\\d?\\d?$")) return "incorrect";

    //mention the input unit and target unit, if they are same, as test case
    //test case for more than one "."
    //parameterization
    //step_definitions
    public static String convert_Temperature(double initialTemp, String inputUnitOfMeasure, String outputUnitOfMeasure, String studentResponse) {
        final DecimalFormat df1 = new DecimalFormat("0.0");



        // C -> F = (C * 1.8) + 32

        // C -> R = C(1.8) + 491.67
        //Math.round


        ArrayList<String> unitOfMeasurementsList = new ArrayList<>(Arrays.asList("Fahrenheit", "Kelvin", "Celsius", "Rankine"));
        if (!unitOfMeasurementsList.contains(inputUnitOfMeasure) || !unitOfMeasurementsList.contains(outputUnitOfMeasure)) {
            return "invalid";
        } else {
            //in case student response is empty
            if(studentResponse.equals("")){
                return "incorrect";
            }

            ArrayList<String> responseString_BrokenUp_List = new ArrayList<>(Arrays.asList(studentResponse.split("")));

            for (int i = 0; i < responseString_BrokenUp_List.size(); i++) {
                responseString_BrokenUp_List.remove(".");

                Character eachCharacter = responseString_BrokenUp_List.get(i).charAt(0);
                //check for letters and special characters

                if (Character.isLetter(eachCharacter) || !Character.isLetterOrDigit(eachCharacter)) {
                    return "incorrect";
                }

            }
        }

        //authoritative_answer
        double authoritative_Answer = 0;

        //format and round the student response
        double studentResponse_Double = Double.parseDouble(df1.format(Double.parseDouble((studentResponse))));

        /**
        <= Fahrenheit Conversions =>
         */
       if (inputUnitOfMeasure.equals("Fahrenheit")) {

            // F -> C = (F - 32)(5/9)
            if (outputUnitOfMeasure.equals("Celsius")) {
                authoritative_Answer = (initialTemp - 32) * 5 / 9;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // F -> R = F + 459.67
            if (outputUnitOfMeasure.equals("Rankine")) {
                authoritative_Answer = (initialTemp + 459.67);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // F -> K = (F - 32)(5/9) + 273.15
            if (outputUnitOfMeasure.equals("Kelvin")) {
                authoritative_Answer = ((initialTemp - 32) * 5 / 9) + 273.15;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }


        }

        /**
         <= Celsius Conversions =>
         */
        if (inputUnitOfMeasure.equals("Celsius")) {

            // C -> F = (C * 1.8) + 32
            if (outputUnitOfMeasure.equals("Fahrenheit")) {
                authoritative_Answer = (initialTemp * 1.8) + (32);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // C -> R = C(1.8) + 491.67
            if (outputUnitOfMeasure.equals("Rankine")) {
                authoritative_Answer = (initialTemp * 1.8) + (491.67);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // C -> K = C + 273.15
            if (outputUnitOfMeasure.equals("Kelvin")) {
                authoritative_Answer = initialTemp + 273.15;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }


        }

        /**
         <= Rankine Conversions =>
         */
        if (inputUnitOfMeasure.equals("Rankine")) {

            // R -> F = R − 459.67
            if (outputUnitOfMeasure.equals("Fahrenheit")) {
                authoritative_Answer = (initialTemp - 459.67);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // R -> C = ( R − 491.67) × 5/9
            if (outputUnitOfMeasure.equals("Celsius")) {
                authoritative_Answer = (initialTemp - 491.67) * 5 / 9;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // R -> K = R * 5/9
            if (outputUnitOfMeasure.equals("Kelvin")) {
                authoritative_Answer = initialTemp * 5 / 9;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }


        }

        /**
         <= Kelvin Conversions =>
         */
        if (inputUnitOfMeasure.equals("Kelvin")) {

            // K -> F = (K − 273.15) × 9/5 + 32
            if (outputUnitOfMeasure.equals("Fahrenheit")) {
                authoritative_Answer = ((initialTemp - 273.15) * 9 / 5) + 32;
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // K -> C = K − 273.15
            if (outputUnitOfMeasure.equals("Celsius")) {
                authoritative_Answer = (initialTemp - 273.15);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }

            // K -> R = K * 1.8
            if (outputUnitOfMeasure.equals("Rankine")) {
                authoritative_Answer = initialTemp * (1.8);
                if (Double.parseDouble(df1.format(authoritative_Answer)) == studentResponse_Double) {
                    return "correct";
                }
            }


        }

        return "incorrect";

    }


}
