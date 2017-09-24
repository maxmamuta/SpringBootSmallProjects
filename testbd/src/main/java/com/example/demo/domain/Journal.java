package com.example.demo.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by maxmamuta on 9/10/17.
 */
public class Journal {

    private long id;
    private String title;
    private Date created;
    private String summary;

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    Journal() {}

    public Journal(long id, String title, String summary, Date created) throws ParseException {
        this.id = id;
        this.title = title;
        this.created = created;
        this.summary = summary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public String getCreatedAsShort() {
        return format.format(created);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", summary='" + summary + '\'' +
                ", format=" + format +
                '}';
    }
}
