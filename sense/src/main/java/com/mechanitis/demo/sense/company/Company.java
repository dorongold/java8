package com.mechanitis.demo.sense.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by doron on 8/8/15.
 */
public enum Company {

//    VMWARE("vmware", "vm-ware"),
//    MICROSOFT("microsoft", "micro-soft"),
//    ORACLE("oracle"),
//    GOOGLE("google"),
//    APPLE("apple"),
//    DOCKER("docker");

    ICE_CREAM("ice-cream", "icecream"),
    HAMBURGER("hamburger"),
    PIZZA("pizza"),
    SUSHI("sushi"),
    CHEESEBURGER("cheeseburger", "cheese-burger");

    private List<String> names;

    Company(String... names) {
        this.names = Arrays.stream(names).collect(Collectors.toList());
    }

    public List<String> getNames() {
        return this.names;
    }

    public static Optional<Company> getByName(String name) {
        return Stream.of(values()).
                filter(company -> company.getNames().contains(name)).
                findFirst();
    }

}
