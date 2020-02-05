package com.example.LocationAPI.LocationAPI;


import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
public class Location {

    @Id
    private Long id;

    private String username;

    private String imageName;

    private String title;

    private String description;

    private Date targetDate;

    public Location() {

    }

    public Location(Long id, String username, String imageName, String title, String description, Date targetDate) {
        this.id = id;
        this.username = username;
        this.imageName = imageName;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username ,title, description, targetDate, imageName);
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
                ", imageName='" + imageName + '\'' +
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
