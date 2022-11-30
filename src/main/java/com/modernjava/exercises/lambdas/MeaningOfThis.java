package com.modernjava.exercises.lambdas;

import org.springframework.http.converter.json.GsonBuilderUtils;
/* a classic java puzzle: what would be the output? 4, 5, 6 or 42?) */
public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        System.out.println("here, this refers to the class MeaningOfThis" + this.value);
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println("here, this refers to Runnable " +this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
