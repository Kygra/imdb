package com.henrique.imdb.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(generator = "movie_id")
    @GenericGenerator(name = "movie_id",
            parameters = @Parameter(name = "prefix", value = "movie"),
            strategy = "com.henrique.imdb.util.PrefixIdGenerator")
    private String id;

    private String title;

    private String description;

    private Date publishingDate;

    public Movie() {}

    public Movie(String title, String description, Date publishingDate) {
        this.title = title;
        this.description = description;
        this.publishingDate = publishingDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
