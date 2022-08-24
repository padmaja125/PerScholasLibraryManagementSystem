package com.project.perscholaslms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestUsingFields {

    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public String firstName;
    @Parameterized.Parameter(1)
    public String lastName;
    @Parameterized.Parameter(2)
    public String middleName;
    @Parameterized.Parameter(3)
    public String fullName;

    // creates the test data
    @Parameterized.Parameters(name = "{index}: Test with m1={0}, m2 ={1},m3={2} result is:{3} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"Padmaja", "Ramesh", "Vimal", "Padmaja Vimal Ramesh"}, {"Prem", "Dev", "Vimal", "Prem Vimal Dev"}, {"Dev", "Vimal", "Prem", "Dev Prem Vimal"}};
        return Arrays.asList(data);
    }


    @Test
    public void FullNameTest() {
        ToTestClass tester = new ToTestClass();
        assertEquals("Result", fullName, tester.fullName(firstName, middleName, lastName));
    }


    // class to be tested
    private class ToTestClass {
        public String fullName(String i, String j, String K) {
            return i + " "+ j + " "+ K;
        }
    }

}

