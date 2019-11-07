package com.victoryw.ab.test;

import org.jooq.lambda.Seq;

public class Sample {
    public static String example1() {
        return "baseline";
    }

    public static String example2() {
        final Seq<Integer> concat = Seq.of(1, 2, 3).concat(Seq.of(4, 5, 6));
        return concat.reduce(0, Integer::sum).toString().concat("_baseline");
    }
}
