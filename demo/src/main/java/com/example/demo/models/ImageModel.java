package com.example.demo.models;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageModel {
    private int id;
    @NotBlank
    private String url;
    @NotBlank
    private String description;
}
