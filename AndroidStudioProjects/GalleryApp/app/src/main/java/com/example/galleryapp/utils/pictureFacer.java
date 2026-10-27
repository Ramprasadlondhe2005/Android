package com.example.galleryapp.utils;

public class pictureFacer {
    private String picName;
    private String picPath;

    public pictureFacer(String picName, String picPath) {
        this.picName = picName;
        this.picPath = picPath;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
