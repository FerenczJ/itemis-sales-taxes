package com.itemis.salestaxes;

import com.itemis.salestaxes.business.BasketImpl;
import com.itemis.salestaxes.business.TaxCalculatorImpl;
import com.itemis.salestaxes.util.ParseException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SalesTaxesApplication {
    public static void main(String[] args) {

        try {
            List<String> allLines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            System.out.println("### INPUT:");
            allLines.forEach(System.out::println);
            System.out.println();
            System.out.println("### OUTPUT:");
            var basket = new BasketImpl(new TaxCalculatorImpl(), allLines);
            basket.out();
        } catch (IOException e) {
            System.out.println(STR."Error while open file: \{e.getMessage()}");
        } catch (ParseException e) {
            System.out.println(STR."Error while parsing line: \{e.getMessage()}");
        }
    }
}