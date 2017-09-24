package testnosql.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by maxmamuta on 9/10/17.
 */
public class Journal {

    @Id
    private String id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    Journal() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Journal(String title, String summary, String created) throws ParseException {
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
