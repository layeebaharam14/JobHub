package com.jobhub;

public class InputValidator {

    // Validate positive integer
    public static boolean isPositive(int value) {
        return value > 0;
    }

    // Validate non-negative integer
    public static boolean isNonNegative(int value) {
        return value >= 0;
    }

    // Validate positive salary
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    // Validate non-empty String
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}