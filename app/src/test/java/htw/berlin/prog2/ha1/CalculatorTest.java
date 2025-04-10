package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    //Teilaufgabe 1
    @Test
    @DisplayName("should give the number 2 in percent")
    void testPercent(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");

        String expected = "0.02";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    //Teilaufgabe 2
    @Test
    @DisplayName("should test negative numbers")
    void testNegativeNumber() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(8);
        calc.pressNegativeKey();
        //calc.pressEqualsKey();     // Funktion vorhanden wenn kein Gleichheitszeichen eingegeben wird

        String expected = "-8";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    /*
    * Fehler 1: Hier wird die Inverse Matrix als Infinity
     */
    @Test
    @DisplayName("should test the inverse of 0. Should give an error")
    void testInverseZero(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);

        calc.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);


    }
}
