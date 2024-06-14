package com.example.demo.controllers;

import com.example.demo.entities.Image;
import com.example.demo.repositories.IImageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {
    private final IImageRepository imageRepository;

    @PostMapping("add-image")
    public ResponseEntity<String> addImage(@RequestBody @Valid Image image) {
        imageRepository.save(image);
        return ResponseEntity.ok("Image added successfully!");
    }

    @GetMapping("get-all-images")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateImage(@PathVariable Long id, @RequestBody Image updatedImage) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image existingImage = imageOptional.get();
            existingImage.setUrl(updatedImage.getUrl());
            existingImage.setDescription(updatedImage.getDescription());
            imageRepository.save(existingImage);
            return ResponseEntity.ok("Image updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
