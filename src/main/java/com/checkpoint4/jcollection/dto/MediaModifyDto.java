package com.checkpoint4.jcollection.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class MediaModifyDto {
    @NotBlank
    @Size( min = 1,max = 45)
    private String title;

    @NotBlank
    @Size(min = 1, max = 120)
    private String artist;

    @NotBlank
    @Size(min = 2, max = 45)
    private String genre;

    private String publishingDate;

    @Size(max = 250)
    private String description;


    //getter&setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
