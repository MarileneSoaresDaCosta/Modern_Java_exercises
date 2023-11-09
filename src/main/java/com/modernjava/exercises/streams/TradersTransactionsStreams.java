package com.modernjava.exercises.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

//    1. find all transactions in year 2011 sorted by value
        List<String> allTransactions2011 = transactions.stream()
                .filter(t -> {
                    return t.getYear() == 2011;
                        })
                .sorted(Comparator.comparing(Transaction::getValue) )
                .map(Transaction::toString)
                .collect(toList());

        System.out.println("=== All 2011 transactions: " +allTransactions2011);

//    2. what are the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map( t -> t.getTrader().getCity())
                .distinct()
                .toList();

        System.out.println("=== Unique cities" +uniqueCities);

//    3. Find all traders from Cambridge and sort them by name
        List<String> allTradersCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        System.out.println("=== Traders' from Cambridge names sorted " + allTradersCambridge);

//    4. return a string of all traders names sorted alphabetically
        String allTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining("-"));

        System.out.println("=== Traders' names sorted and concatenated " + allTraders);

//    5. are any traders based in Milan? expect boolean
       Boolean anyFromMilan = transactions.stream()
               .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println("=== Anyone from Milan? " +anyFromMilan);

//    6. print all transactions values from the traders living in Cambridge
        List<Integer> allTransactionsCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .toList();
        System.out.println("=== values, Traders from Cambridge " +allTransactionsCambridge);

//    7. what is the highest value of all the transactions?
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("=== Highest value: " +maxValue);

//    8. find the transaction with the smallest value
        Optional<Integer> minValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("=== Lowest value: " +minValue);
    }


}
