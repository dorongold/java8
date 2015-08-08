package com.mechanitis.demo.sense.company;

import com.mechanitis.demo.sense.twitter.TweetParser;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by doron on 8/8/15.
 */


public class CompanyExtractor {
    public static CompanyMessage extractCompany(String fullMessage) {
        String[] wordsInMessage = TweetParser.getTweetMessageFrom(fullMessage).split(" ");
        Set<Company> companies = Stream.of(wordsInMessage).
                map(word -> Company.getByName(StringUtils.remove(word.toLowerCase(), '#'))).
                filter(companyOptional -> companyOptional.isPresent()).
                map(Optional::get).
                collect(Collectors.toSet());
        return new CompanyMessage(companies);
    }
}
