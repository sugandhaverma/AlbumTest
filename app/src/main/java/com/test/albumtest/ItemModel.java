package com.test.albumtest;

public class ItemModel {
    private int image;
    private String Name;
    private String songName;
    private String Price;

    public ItemModel(int image, String name, String songName, String price) {
        this.image = image;
        Name = name;
        this.songName = songName;
        Price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
