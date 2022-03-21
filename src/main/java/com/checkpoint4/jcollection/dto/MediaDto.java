package com.checkpoint4.jcollection.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class MediaDto {
    @NotBlank
    @Size(min = 3, max = 45)
    private String name;

    @NotBlank
    @Size(min = 3, max = 120)
    private String artist;

    @NotBlank
    @Size(min = 2, max = 45)
    private String genre;

    private Date publishingDate;

    @Size(max = 250)
    private String description;

    @NotNull
    private Long typeId;

    //getter&setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
