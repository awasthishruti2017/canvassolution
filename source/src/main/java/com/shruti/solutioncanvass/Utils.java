package com.shruti.solutioncanvass;

public class Utils {
    public static int toPositiveInt(String input) throws IllegalArgumentException {
        int i = Integer.parseInt(input);
        if (i <= 0)
            throw new IllegalArgumentException();

        return i;
    }

    public static void shouldAllPositive(int... numbers) {
        for (int num : numbers) {
            if (num < 1) {
                throw new IllegalArgumentException("Number should be > 0");
            }
        }
    }

    public static void shouldAllNonNegative(int... numbers) {
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException("Number should be > 0");
            }
        }
    }
}
