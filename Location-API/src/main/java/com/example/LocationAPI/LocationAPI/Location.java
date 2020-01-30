package com.example.LocationAPI.LocationAPI;

import java.util.Date;
import java.util.Objects;

public class Location {

    private long id;
    private String username;
    private String title;
    private String description;
    private Date targetDate;

    public Location(long id, String username ,String title, String description, Date targetDate) {
        super();
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username ,title, description, targetDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Location other = (Location) o;
        if (id != other.id) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
