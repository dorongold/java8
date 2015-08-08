package com.mechanitis.demo.sense.company;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by doron on 8/8/15.
 */
public class CompanyMessage {

    private final Set<Company> companies;

    CompanyMessage(Set<Company> companies) {
        this.companies = companies;
    }

    public boolean hasCompany(Company mood) {
        return companies.contains(mood);
    }

    @Override
    public String toString() {
        return companies.stream().
                map(Enum::toString).
                collect(Collectors.joining(","));
    }

}
