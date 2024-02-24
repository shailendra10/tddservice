package com.example.tddservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArithmeticOpSevice {
    public  String commaDelimiter = ",";
    public  String newLineDelimiter  = "\n";

    public  String invalidDelimiter  = "";

    public Integer add (String numbers) throws RuntimeException {

        if (numbers.isEmpty()) {
            return 0;
        }

        if(numbers.charAt(0) == '/'  && numbers.charAt(1) == '/') {
            commaDelimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4);
            System.out.println("After replacement : " + numbers + "COMMA_DELIMITER" + commaDelimiter);
        }

        invalidDelimiter = commaDelimiter + newLineDelimiter;

        if(numbers.contains(invalidDelimiter)) {
            throw new RuntimeException("Invalid Input String");
        }

        List<String> numberStrings = numbers.lines().toList();

        List<Integer> numsInAllLines = new ArrayList<>();

        for(String str : numberStrings) {
            System.out.println("str :" + str + "COMMA_DELIMITER " + commaDelimiter);
            String[] strings = str.split(commaDelimiter);
            List <Integer> intValues = Arrays.stream(strings)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();

            numsInAllLines.addAll(intValues);
        }

        int sum = 0;

        boolean hasNegativeNumber = false;
        StringBuilder negativeNumbers = new StringBuilder();
        int negativeNumCount = 0;
        for(Integer number : numsInAllLines) {
            if(number >= 0) {
                sum = sum + number;
            } else {
                hasNegativeNumber = true;
                ++negativeNumCount;

                if(negativeNumCount == 1) {
                    negativeNumbers.append(""+number);
                } else {
                    negativeNumbers.append(","+number);
                }
            }
        }

        if(hasNegativeNumber) {
            throw new RuntimeException("negative numbers not allowed " + negativeNumbers);
        } else {
            return sum;
        }
    }
}
