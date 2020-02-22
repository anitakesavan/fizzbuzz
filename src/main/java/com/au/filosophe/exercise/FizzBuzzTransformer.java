package com.au.filosophe.exercise;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.String.valueOf;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * This service provides methods to transform any given number to "Fizz", "Buzz"
 * or "FizzBuzz" based on certain rules.
 *
 * @author Anita Kesavan
 * @version 1.0
 * @since 21-Feb-2019
 */
public class FizzBuzzTransformer {

    public static final String BUZZ = "Buzz";
    public static final String FIZZ = "Fizz";

    /**
     * Conditionally transforms given range of numbers and returns a list of string values.
     * Returns empty list if either parameter is negative or zero.
     * Returns empty list if begin is greater than end.
     * Returns empty list if end parameter is equal to maximum integer value.
     *
     * @param begin starting number inclusive
     * @param end   ending number inclusive
     * @return list of string values
     */
    public List<String> transformRange(final int begin, final int end) {
        if (begin < 1 || end < 1 || begin > end || end == MAX_VALUE) {
            return emptyList();
        }

        return range(begin, end + 1)
                .boxed()
                .map(number -> transform(number))
                .collect(toList());
    }

    /**
     * Transforms given number to Fizz, Buzz or FizzBuzz based on following rules :
     * <p>
     * If number is multiple of 3, return "Fizz"
     * If number is multiple of 5, return "Buzz"
     * If number is multiple of both 3 and 5, return "FizzBuzz"
     * If none of the above rules is applied, return the number
     * <p>
     * Returns null if parameter is negative or zero
     *
     * @param number
     * @return String value
     */
    public String transform(final int number) {
        if (number <= 0) {
            return null;
        }
        if (number % 15 == 0) {
            return FIZZ + BUZZ;
        }
        if (number % 5 == 0) {
            return BUZZ;
        }
        if (number % 3 == 0) {
            return FIZZ;
        }
        return valueOf(number);
    }
}