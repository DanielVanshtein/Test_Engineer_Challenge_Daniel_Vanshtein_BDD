package com.assignment_Test.pojo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Temperature_Inputs {

    private Double input_Numerical_Value;
    private String input_Unit_Of_Measure;
    private String target_Unit_Of_Measure;
    private String student_Response;

    public static Temperature_Inputs testCase;



}
