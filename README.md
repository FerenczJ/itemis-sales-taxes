# SALES TAXES

## Introduction

This is an application for Itemis interview. Application receives items of a basket and calculates summary and taxes.

## Problem

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items
I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax
rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
sales tax.

## Prerequisites
* [JAVA 21](https://www.java.com/en/download/) SDK or later version
* [Apache Maven 3.9.6](https://maven.apache.org/) - dependency management tool

## Build
For build the application use the following command in the project root:
```
mvn install
mvn clean package
```

## Run
For run the application for different input files use the following commands in the project root:
```
java --enable-preview -jar target/itemis-sales-taxes-0.1.0.jar target/classes/input1.txt
java --enable-preview -jar target/itemis-sales-taxes-0.1.0.jar target/classes/input2.txt
java --enable-preview -jar target/itemis-sales-taxes-0.1.0.jar target/classes/input3.txt
```

## NOTES
* I tried out experimental feature of Java 21 with strings, --enable-preview needed for this
* Input files packaged to the application for faster evaluation, I wouldn't do that in real world scenario :)
* I used enums for products, in a real world scenario I would use a database to get information about products.
* I found anomalies in the outputs in the specification:
* * Output 2: 1 imported bottle of perfume at 47.50 -> 47.50 * 1.15 = 54.63 != 54.65 
* * Output 3: 1 imported box of chocolates at 11.25 -> 11.25 * 1.05 = 11.83 != 11.85
