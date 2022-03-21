package com.checkpoint4.jcollection.controller;

import com.checkpoint4.jcollection.dto.TypeDto;
import com.checkpoint4.jcollection.entity.Type;
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
@RequestMapping("/Type")
public class TypeController {
    @Autowired
    TypeRepository typeRepository;


    //create type
    @PostMapping
    public Type createType(@Valid @RequestBody TypeDto typeDto) {
        Type type = new Type();
        type.setName(typeDto.getName());
        return typeRepository.save(type);
    }

    //Get a type
    @GetMapping("/{id}")
    public Type getType(@PathVariable(required = true) Long id) {
        Optional<Type> optType = typeRepository.findById(id);
        if (optType.isPresent()) {
            return optType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // Get all types
    @GetMapping()
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    //delete a type
    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable(required = true) Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        typeRepository.delete(type);
    }
}
