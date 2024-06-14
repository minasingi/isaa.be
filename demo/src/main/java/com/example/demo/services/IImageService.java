package com.example.demo.services;

import com.example.demo.entities.Image;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void createImage(Image image);
    void deleteImage(Long id);
    List<Image> getAllImages();
    List<Image> getImagesByProductId(Long productId);
    void updateImageUrl(Long id, String imageUrl);
    void updateImageDescription(Long id, String description);
}

