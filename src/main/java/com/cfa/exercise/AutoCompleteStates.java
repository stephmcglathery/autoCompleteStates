package com.cfa.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class AutoCompleteStates {

    /*
        For the given text, return the names of the States that are considered matches.
        There should be no duplicates in the collection.
      A State is a match if it meets one of the following conditions.  Results should be returned
      in the priority listed below where one is highest priority and three is lowest.  If two matches
      are the same priority, those matches should be sorted alphabetically.
      1. Match exact abbreviation (Should be case insensitive)
      2. Match start of state name
      3. Match any part of state name
    */
    public List<String> filterStates(String textEntered) {

        List<String> stateNames = new ArrayList<>();

        if (textEntered != null && !textEntered.isEmpty()) {
            stateNames = Arrays.stream(State.values())
                    .filter(state -> state.getStateName().toUpperCase().contains(textEntered.toUpperCase())
                            || state.getAbbreviation().contains(textEntered)
                    )
                    .sorted(Comparator.comparing(x -> x.getStateName()))
                    .sorted(Comparator.comparing(x -> !x.getStateName().toUpperCase().startsWith(textEntered.toUpperCase())))
                    .map(State::getStateName)
                    .collect(Collectors.toList());
        }

        return stateNames;
    }

}
