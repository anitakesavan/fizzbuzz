package com.au.filosophe.exercise;

import org.junit.Test;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class FizzBuzzTransformerTest {

    private FizzBuzzTransformer fizzBuzzTransformer = new FizzBuzzTransformer();

    @Test
    public void shouldReturnNullOnTransformIfInputIsNegativeOrZero() {
        final int[] testData = new int[]{MIN_VALUE, -9999, -100, 0};
        for (final int testInput : testData) {
            assertThat(fizzBuzzTransformer.transform(testInput), nullValue());
        }
    }

    @Test
    public void shouldReturnFizzOnTransformIfInputIsMultipleOf3() {
        final int[] testData = new int[]{3, 9, 3003, MAX_VALUE - 1};
        for (final int testInput : testData) {
            assertThat(fizzBuzzTransformer.transform(testInput), is("Fizz"));
        }
    }

    @Test
    public void shouldReturnBuzzOnTransformIfInputIsMultipleOf5() {
        final int[] testData = new int[]{5, 20, 50000, MAX_VALUE - 2};
        for (final int testInput : testData) {
            assertThat(fizzBuzzTransformer.transform(testInput), is("Buzz"));
        }
    }

    @Test
    public void shouldReturnBuzzOnTransformIfInputIsMultipleOf15() {
        final int[] testData = new int[]{15, 60, 75000, 518670};
        for (final int testInput : testData) {
            assertThat(fizzBuzzTransformer.transform(testInput), is("FizzBuzz"));
        }
    }

    @Test
    public void shouldReturnNumberOnTransformIfInputIsNotMultipleOf3or5() {
        final int[] testData = new int[]{2, 4, 8, 32, 17, 23, 91, 119, 51868};
        for (final int testInput : testData) {
            assertThat(fizzBuzzTransformer.transform(testInput), is(String.valueOf(testInput)));
        }
    }

    @Test
    public void shouldReturnEmptyListOnTransformRangeIfFirstInputIsNegativeOrZero() {
        final int[] invalidInputs = new int[]{MIN_VALUE, -9999, -100, 0};
        final int secondInput = 100;
        for (final int firstInput : invalidInputs) {
            assertThat(fizzBuzzTransformer.transformRange(firstInput, secondInput).size(), is(0));
        }
    }

    @Test
    public void shouldReturnEmptyListOnTransformRangeIfSecondInputIsNegativeOrZero() {
        final int[] invalidInputs = new int[]{MIN_VALUE, -9999, -100, 0};
        final int firstInput = 1;
        for (final int secondInput : invalidInputs) {
            assertThat(fizzBuzzTransformer.transformRange(firstInput, secondInput).size(), is(0));
        }
    }

    @Test
    public void shouldReturnEmptyListOnTransformRangeIfBothInputIsNegativeOrZero() {
        final int[] invalidFirstInputs = new int[]{MIN_VALUE, -9999, 0};
        final int[] invalidSecondInputs = new int[]{MIN_VALUE, -478, 0};

        for (final int firstInput : invalidFirstInputs) {
            for (final int secondInput : invalidSecondInputs) {
                assertThat(fizzBuzzTransformer.transformRange(firstInput, secondInput).size(), is(0));
            }
        }
    }

    @Test
    public void shouldReturnEmptyListOnTransformRangeIfSecondInputIsMaxIntValue() {
        final int[] validInputs = new int[]{1, 34343, 20684};

        for (final int firstInput : validInputs) {
            assertThat(fizzBuzzTransformer.transformRange(firstInput, MAX_VALUE).size(), is(0));
        }
    }

    @Test
    public void shouldReturnListWithSingleValueOnTransformRangeWhenBothInputsAreValidAndSame() {
        {
            final List<String> result = fizzBuzzTransformer.transformRange(1, 1);
            assertThat(result.size(), is(1));
            assertThat(result.get(0), is("1"));
        }
        {
            final List<String> result = fizzBuzzTransformer.transformRange(303, 303);
            assertThat(result.size(), is(1));
            assertThat(result.get(0), is("Fizz"));
        }
        {
            final List<String> result = fizzBuzzTransformer.transformRange(5, 5);
            assertThat(result.size(), is(1));
            assertThat(result.get(0), is("Buzz"));
        }
        {
            final List<String> result = fizzBuzzTransformer.transformRange(45, 45);
            assertThat(result.size(), is(1));
            assertThat(result.get(0), is("FizzBuzz"));
        }
    }

    @Test
    public void shouldReturnListOfValidTranformationOnTransformRangeWhenBothInputsAreValid() {
        {
            final List<String> result = fizzBuzzTransformer.transformRange(1, 15);
            assertThat(result.size(), is(15));
            assertThat(result.toString(), is("[1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]"));
        }

        {
            final List<String> result = fizzBuzzTransformer.transformRange(67, 80);
            assertThat(result.size(), is(14));
            assertThat(result.toString(), is("[67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz]"));
        }

        {
            final List<String> result = fizzBuzzTransformer.transformRange(MAX_VALUE - 10, MAX_VALUE - 1);
            assertThat(result.size(), is(10));
            assertThat(result.toString(), is("[Fizz, 2147483638, 2147483639, FizzBuzz, 2147483641, 2147483642, Fizz, 2147483644, Buzz, Fizz]"));
        }
    }
}