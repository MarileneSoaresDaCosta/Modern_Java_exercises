package com.modernjava.exercises.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class TradersTransactionsStreams {

    public static void main(String[] args) {


//    book Java 8 in Action, chapter 5 exercises 5.5
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//    1. find all transactions in year 2011
        List<String> allTransactions2011 = transactions.stream()
                .filter(t -> {
                    return t.getYear() == 2011;
                        })
                .map(Transaction::toString)
                .collect(toList());

        System.out.println("All transactions: " +allTransactions2011);

//    2. what are the unique cities where the traders work?

//    3. Find all traders from Cambridge and sort them by name
//    4. return a string of all traders names sorted alphabetically
//    5. are any traders based in Milan?
//    6. print all transactions values from the traders living in Cambridge
//    7. what is the highest value of all the transactions?
//    8. find the transaction with the smallest value
    }
}
