package com.ksu;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class JmhMain {
    private static final String PASSWORD = "super save password";

        @Benchmark
    public void hash512(Blackhole bh) {
        bh.consume(com.ksu.customerprofile.service.HashService.hash512(PASSWORD, 1));
    }
    @Benchmark
    public void hash256(Blackhole bh) {
        bh.consume(com.ksu.customerprofile.service.HashService.hash256(PASSWORD));
    }
    @Benchmark
    public void hashMD5(Blackhole bh) {
        bh.consume(com.ksu.customerprofile.service.HashService.hashMD5(PASSWORD));
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .mode(Mode.All)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(1)
                .forks(1)
                .warmupForks(0)
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(1))
                .threads(Runtime.getRuntime().availableProcessors() * 16)
                .syncIterations(true)
                .build();

        new Runner(opt).run();
    }

}