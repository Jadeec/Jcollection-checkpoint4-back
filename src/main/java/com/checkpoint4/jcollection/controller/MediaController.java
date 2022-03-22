package com.checkpoint4.jcollection.controller;

import com.checkpoint4.jcollection.dto.MediaDto;
import com.checkpoint4.jcollection.dto.MediaModifyDto;
import com.checkpoint4.jcollection.entity.Media;
import com.checkpoint4.jcollection.entity.Type;
import com.checkpoint4.jcollection.repository.MediaRepository;
import com.checkpoint4.jcollection.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/medias")
public class MediaController {
    @Autowired
    MediaRepository mediaRepository;

    @Autowired
    TypeRepository typeRepository;

    //Create media
    @PostMapping()
    public Media createMedia(@Valid @RequestBody MediaDto mediaDto) {

        //retrieve type
        Type type = typeRepository.findById(mediaDto.getTypeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //createMedia
        Media media = new Media();
        media.setTitle(mediaDto.getTitle());
        media.setArtist(mediaDto.getArtist());
        media.setGenre(mediaDto.getGenre());
        media.setPublishingDate(mediaDto.getPublishingDate());
        media.setDescription(mediaDto.getDescription());
        media.setType(type);
        return mediaRepository.save(media);

    }

    //get a media
    @GetMapping("/{id}")
    public Media getMedia(@PathVariable(required = true) Long id) {
        Optional<Media> otpMedia = mediaRepository.findById(id);
        if (otpMedia.isPresent()) {
            return otpMedia.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    //get medias by type
    @GetMapping("type/{id}")
    public List<Media> getMedias(@PathVariable(required = true) Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mediaRepository.findMediaByType(type);
    }

    //Modify media
    @PutMapping("/{id}")
    public Media modifyMedia(@PathVariable(required = true) Long id, @Valid @RequestBody MediaModifyDto mediaDto) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        media.setTitle(mediaDto.getTitle());
        media.setArtist(mediaDto.getArtist());
        media.setGenre(mediaDto.getGenre());
        media.setPublishingDate(mediaDto.getPublishingDate());
        media.setDescription(media.getDescription());

        return mediaRepository.save(media);
    }

    //delete media
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable(required = true) Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mediaRepository.delete(media);
    }
}
