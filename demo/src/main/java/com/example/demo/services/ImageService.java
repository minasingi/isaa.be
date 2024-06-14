package com.example.demo.services;

import com.example.demo.entities.Image;
import com.example.demo.repositories.IImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService {
    private final IImageRepository imageRepository;

    @Override
    public Image getImageById(Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        return imageOptional.orElse(null);
    }

    @Override
    public void createImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByProductId(Long productId) {
        return null;
    }

    @Override
    public void updateImageUrl(Long id, String imageUrl) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image existingImage = imageOptional.get();
            existingImage.setUrl(imageUrl);
            imageRepository.save(existingImage);
        }
    }

    @Override
    public void updateImageDescription(Long id, String description) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image existingImage = imageOptional.get();
            existingImage.setDescription(description);
            imageRepository.save(existingImage);
        }
    }
}
