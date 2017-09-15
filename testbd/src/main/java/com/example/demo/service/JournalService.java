package com.example.demo.service;

import com.example.demo.domain.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maxmamuta on 9/14/17.
 */
@Service
public class JournalService {

    private static final Logger log = LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData() {
        log.info("> Table creation");
        jdbcTemplate.execute("DROP TABLE JOURNAL IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE JOURNAL(id SERIAL, title VARCHAR(255), summary VARCHAR(255), created TIMESTAMP)");
        log.info("> Inserting data...");
        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Get to know Spring Boot', 'Today I will learn Spring Boot', '2016-01-01 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Simple Spring Boot Project', 'I will do my first Spring Project', '2016-01-01 00:00:00.00')");
        log.info("> Done");
    }

    public List<Journal> findAll() {
        List<Journal> entries = new ArrayList<>();
        try {
            jdbcTemplate.query("SELECT * FROM JOURNAL",
                    new Object[]{},
                    (rs, row) -> {
                        try {
                            return new Journal(rs.getLong("id"),
                                    rs.getString("title"), rs.getString("summary"),
                                    new Date(rs.getTimestamp("created").getTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return null;
                    })
                    .forEach(entry -> entries.add(entry));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
