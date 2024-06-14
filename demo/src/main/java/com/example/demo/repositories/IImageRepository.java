package com.example.demo.repositories;

import com.example.demo.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
