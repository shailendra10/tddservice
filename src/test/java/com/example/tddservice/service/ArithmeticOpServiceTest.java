package com.example.tddservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArithmeticOpServiceTest {


    @Test
    public void emptyStringTest() {
        String inputStr = "";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

        int result = arithmeticOpSevice.add(inputStr);
        Assertions.assertEquals(0, result);

    }

    @Test
    public void validStringTest() {
        String inputStr = "1,2,3";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

        int result = arithmeticOpSevice.add(inputStr);
        Assertions.assertEquals(6, result);

    }

    @Test
    public void invalidInputTest() {
            String inputStr = "one,2,3";
            ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

            Assertions.assertThrows(Exception.class, () ->  arithmeticOpSevice.add(inputStr));
    }

    @Test
    public void validNewLineStrTest() {
        String inputStr = "1\n2,3";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();


        int result = arithmeticOpSevice.add(inputStr);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void invalidDelimiterStrTest() {
        String inputStr = "1,\n2,3";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

        RuntimeException rte = Assertions.assertThrows(RuntimeException.class, () -> arithmeticOpSevice.add(inputStr));
        Assertions.assertEquals("Invalid Input String", rte.getMessage());
    }

    @Test
    public void negativeNumberStrTest() {
        String inputStr = "1\n2,-3";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

        RuntimeException rte = Assertions.assertThrows(RuntimeException.class, () -> arithmeticOpSevice.add(inputStr));
        Assertions.assertEquals("negative numbers not allowed -3", rte.getMessage());
    }

    @Test
    public void newDelimiterTest() {
        String inputStr = "//;\n1;3;4";
        ArithmeticOpSevice arithmeticOpSevice = new ArithmeticOpSevice();

        arithmeticOpSevice.add(inputStr);
        int result = arithmeticOpSevice.add(inputStr);
        Assertions.assertEquals(8, result);
    }
}
