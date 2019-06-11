package com.example.demohf.local.vo;

import android.graphics.Bitmap;

import java.sql.Timestamp;

public class Store {
    private int no, num;
    private String name, img;
    private Bitmap image;
    private Timestamp regdate;

    public Store(int no , String name , int num , Bitmap image , String regdate ){
        this.no = no ;
        this.name = name;
        this.num = num;
        this.image = image;
        this.regdate = Timestamp.valueOf(regdate);
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public int getNo() {
        return no;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }
}
