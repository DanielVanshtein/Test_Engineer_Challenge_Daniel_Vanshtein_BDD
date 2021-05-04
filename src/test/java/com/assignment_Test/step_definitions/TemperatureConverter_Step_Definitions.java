package com.assignment_Test.step_definitions;

import com.assignment_Test.pojo.Temperature_Inputs;

import static com.assignment_Test.pojo.Temperature_Inputs.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.Verify;
import org.junit.Assert;


public class TemperatureConverter_Step_Definitions {

    @Given("Student is provided with a {double}")
    public void student_is_provided_with_a(Double double1) {
        testCase = new Temperature_Inputs();
        testCase.setInput_Numerical_Value(double1);
    }

    @Given("Student is provided with a {string} as initial unit")
    public void student_is_provided_with_a_as_initial_unit(String string) {
        testCase.setInput_Unit_Of_Measure(string);

    }

    @Given("Student is provided with a {string} as target unit")
    public void student_is_provided_with_a_as_target_unit(String string) {
        testCase.setTarget_Unit_Of_Measure(string);

    }

    @When("Student inputs their {string} into the input field")
    public void student_inputs_their_into_the_input_field(String string) {
        testCase.setStudent_Response(string);

    }

    @Then("Student should see the appropriate {string} message displayed")
    public void student_should_see_the_appropriate_message_displayed(String expectedResult) {
        String actualResult = com.assignment_Dev.Temperature_Converter_Main.convert_Temperature(
                testCase.getInput_Numerical_Value(),
                testCase.getInput_Unit_Of_Measure(),
                testCase.getTarget_Unit_Of_Measure(),
                testCase.getStudent_Response()
        );

        Assert.assertEquals(actualResult, expectedResult);
        Verify.verify(actualResult.equals(expectedResult));
    }


}
