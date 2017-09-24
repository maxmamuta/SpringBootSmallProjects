package com.molarmak.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by maxmamuta on 9/10/17.
 */
public class JournalEntry {

    private String title;
    private Date created;
    private String summary;

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    JournalEntry() {}

    public JournalEntry(String title, String summary, String created) throws ParseException {
        this.title = title;
        this.created = format.parse(created);
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(String date) throws ParseException {
        Long _date = null;
        try {
            _date = Long.parseLong(date);
            this.created = new Date(_date);
            return;
        } catch (Exception e) {}
        this.created = format.parse(date);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "title='" + title + '\'' +
                ", created=" + created +
                ", summary='" + summary + '\'' +
                '}';
    }
}
