package com.markklim.algo.graph.breadth_first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.markklim.algo.util.Assertions.assertEquals;

public class FindMangoSeller {
    public static void main(String[] args) {
        String start = "belka";
        String finish = "drug_m";
        String notFound = "notFound";

        Map<String, List<String>> friendsMap = Map.of(
                "belka", List.of("ej", "pauk", "gus"),
                "ej", List.of("pauk", "belka", "medved"),
                "pauk", List.of("ej", "medved", "shtrudel", "gus", "belka"),
                "gus", List.of("shtrudel", "belka"),
                "chervyak", List.of("drug_m"),
                "pudel", List.of("ej", "pauk", "medved", "shtrudel"),
                "shtrudel", List.of("pauk"),
                "medved", List.of("ej", "gus", "chervyak"),
                "drug_m", List.of("chervyak")
        );

        assertEquals(finish, findPerson(friendsMap, start, finish));
        assertEquals(start, findPerson(friendsMap, start, start));
        assertEquals("Not found", findPerson(friendsMap, start, notFound));
    }

    private static String findPerson(Map<String, List<String>> friendsMap,
                                     String startPerson, String finishPerson) {
        if (startPerson.equals(finishPerson)) {
            return finishPerson;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(friendsMap.get(startPerson));

        List<String> processedPersons = new ArrayList<>();
        processedPersons.add(startPerson);

        while (!queue.isEmpty()) {
            String person = queue.pollFirst();

            if (person.equals(finishPerson)) {
                return finishPerson;
            }

            processedPersons.add(person);

            friendsMap.get(person).forEach(friendOfFriend -> {
                if (!processedPersons.contains(friendOfFriend)) {
                    queue.addLast(friendOfFriend);
                }
            });
        }

        return "Not found";
    }
}
