package com.checkpoint4.jcollection.dto;

import com.checkpoint4.jcollection.entity.Media;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class TypeDto {
    @NotBlank
    @Size( max = 45)
    private String name;

    private List<Media> medias;

    //getter&setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }
}
