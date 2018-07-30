package models;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Picture {
    private Long id;
    private String name;
    private String photographer;
    private String details;
    private String category;
    private String pathToImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String image) {
        this.pathToImage = image;
    }
}
