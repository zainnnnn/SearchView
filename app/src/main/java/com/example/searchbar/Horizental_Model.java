package com.example.searchbar;

public class Horizental_Model {

    String title;
    int image;

    public Horizental_Model(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public Horizental_Model(String title, int Image) {
        this.title = title;
        this.image = Image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
