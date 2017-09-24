package com.molarmak.controller;

import com.molarmak.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maxmamuta on 9/10/17.
 */
@RestController
public class JournalEntryController {

    private static List<JournalEntry> entries = new ArrayList<>();

    static {
        try {
            entries.add(new JournalEntry("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
            entries.add(new JournalEntry("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
            entries.add(new JournalEntry("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
            entries.add(new JournalEntry("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/journal/all")
    public List<JournalEntry> getAll() throws ParseException {
        return entries;
    }

    @RequestMapping("/journal/findBy/title/{title}")
    public List<JournalEntry> findByTitleContains(@PathVariable String title) throws ParseException {
        return entries
                .stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/journal", method = RequestMethod.POST)
    public JournalEntry add(@RequestBody JournalEntry entry) {
        entries.add(entry);
        return entry;
    }

}
