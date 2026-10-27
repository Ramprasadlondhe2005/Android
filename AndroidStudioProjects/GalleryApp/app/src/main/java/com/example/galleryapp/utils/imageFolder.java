package com.example.galleryapp.utils;

public class imageFolder {
    private String path;
    private String folderName;
    private int numberOfPics;
    private String firstPic;

    // Constructor
    public imageFolder() {
    }

    // Getters and setters
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFirstPic() {
        return firstPic;
    }

    public void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }

    // Method to increment numberOfPics
    public void addpics() {
        numberOfPics++;
    }

    // Getter for numberOfPics
    public int getNumberOfPics() {
        return numberOfPics;
    }
}
