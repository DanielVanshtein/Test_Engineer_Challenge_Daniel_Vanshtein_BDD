Feature: Test inputs for Temperature Converter

  @wip
  Scenario Outline: Verify temperature conversion output is correct
    Given Student is provided with a <input numerical value>
    And Student is provided with a "<input unit of measurement>" as initial unit
    And Student is provided with a "<target unit of measurement>" as target unit
    When Student inputs their "<response>" into the input field
    Then Student should see the appropriate "<output>" message displayed

    Examples:
      | input numerical value | input unit of measurement | target unit of measurement | response | output    |
      | 84.2                  | Fahrenheit                | Rankine                    | 543.94   | correct   |
      | 317.33                | Kelvin                    | Fahrenheit                 | 111.554  | incorrect |
      | 317.33                | Kelvin                    | Fahrenheit                 | 111.554  | correct   |
      | 6.5                   | Fahrenheit                | Rankine                    | dog      | incorrect |
      | 136.1                 | dogcow                    | Celsius                    | 45.32    | invalid   |
      | 200.65                | Kelvin                    | catdog                     | 34.67    | invalid   |
      | 200.65                | Kelvin                    | Celsius                    |          | incorrect |
