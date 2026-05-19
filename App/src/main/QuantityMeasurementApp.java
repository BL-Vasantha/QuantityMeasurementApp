package main;

public class QuantityMeasurementApp {

    // Equality Demo
    public static <U extends Measurable>
    void demonstrateEquality(
            Quantity<U> first,
            Quantity<U> second
    ) {

        System.out.println(
                first + ".equals(" +
                        second + ") => " +
                        first.equals(second)
        );

        System.out.println();
    }

    // Conversion Demo
    public static <U extends Measurable>
    void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit
    ) {

        System.out.println(
                quantity + ".convertTo(" +
                        targetUnit + ") => " +
                        quantity.convertTo(targetUnit)
        );

        System.out.println();
    }

    // Addition Demo
    public static <U extends Measurable>
    void demonstrateAddition(
            Quantity<U> first,
            Quantity<U> second,
            U targetUnit
    ) {

        System.out.println(
                first + ".add(" +
                        second + ", " +
                        targetUnit + ") => " +
                        first.add(
                                second,
                                targetUnit
                        )
        );

        System.out.println();
    }

    // Subtraction Demo
    public static <U extends Measurable>
    void demonstrateSubtraction(
            Quantity<U> first,
            Quantity<U> second,
            U targetUnit
    ) {

        System.out.println(
                first + ".subtract(" +
                        second + ", " +
                        targetUnit + ") => " +
                        first.subtract(
                                second,
                                targetUnit
                        )
        );

        System.out.println();
    }

    // Division Demo
    public static <U extends Measurable>
    void demonstrateDivision(
            Quantity<U> first,
            Quantity<U> second
    ) {

        System.out.println(
                first + ".divide(" +
                        second + ") => " +
                        first.divide(second)
        );

        System.out.println();
    }

    public static void main(String[] args) {

        // Volume Quantities
        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> gallon =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        // Equality
        demonstrateEquality(
                litre,
                millilitre
        );

        demonstrateEquality(
                gallon,
                new Quantity<>(
                        3.78541,
                        VolumeUnit.LITRE
                )
        );

        // Conversion
        demonstrateConversion(
                litre,
                VolumeUnit.MILLILITRE
        );

        demonstrateConversion(
                gallon,
                VolumeUnit.LITRE
        );

        // Addition
        demonstrateAddition(
                litre,
                millilitre,
                VolumeUnit.LITRE
        );

        demonstrateAddition(
                gallon,
                litre,
                VolumeUnit.GALLON
        );

        // Length Subtraction
        demonstrateSubtraction(
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET
                ),
                new Quantity<>(
                        6.0,
                        LengthUnit.INCHES
                ),
                LengthUnit.FEET
        );

        // Weight Subtraction
        demonstrateSubtraction(
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM
                ),
                new Quantity<>(
                        5000.0,
                        WeightUnit.GRAM
                ),
                WeightUnit.KILOGRAM
        );

        // Volume Subtraction
        demonstrateSubtraction(
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE
                ),
                new Quantity<>(
                        500.0,
                        VolumeUnit.MILLILITRE
                ),
                VolumeUnit.LITRE
        );

        // Division Operations
        demonstrateDivision(
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET
                ),
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET
                )
        );

        demonstrateDivision(
                new Quantity<>(
                        24.0,
                        LengthUnit.INCHES
                ),
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET
                )
        );

        demonstrateDivision(
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM
                ),
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM
                )
        );
    }
}