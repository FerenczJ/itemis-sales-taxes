package com.itemis.salestaxes;

import com.itemis.salestaxes.business.Basket;
import com.itemis.salestaxes.business.TaxCalculatorImpl;
import com.itemis.salestaxes.model.Item;
import com.itemis.salestaxes.util.ParseException;
import com.itemis.salestaxes.util.ParseUtil;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.itemis.salestaxes.util.ParseUtil.parseItem;
import static java.util.stream.Collectors.toList;

public class SalesTaxesApplication {
    public static void main(String[] args) {

        try {
            List<String> allLines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            System.out.println("### INPUT:");
            allLines.forEach(System.out::println);
            System.out.println();
            System.out.println("### OUTPUT:");
            var basket = new Basket(new TaxCalculatorImpl(), allLines);
            basket.out();
        } catch (IOException e) {
            System.out.println(STR."Error while open file: \{e.getMessage()}");
        } catch (ParseException e) {
            System.out.println(STR."Error while parsing line: \{e.getMessage()}");
        }
    }
}