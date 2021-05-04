package com.assignment_Test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature_Inputs {

    @JsonProperty("input numerical value")
    private Double input_Numerical_Value;

    @JsonProperty("input unit of measurement")
    private String input_Unit_Of_Measure;

    @JsonProperty("target unit of measurement")
    private String target_Unit_Of_Measure;

    @JsonProperty("response")
    private String student_Response;

    public static Temperature_Inputs testCase;



}
