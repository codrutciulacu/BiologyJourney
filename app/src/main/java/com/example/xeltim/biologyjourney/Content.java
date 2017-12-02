package com.example.xeltim.biologyjourney;
/**
 * Created by CiulacuCodrut on 11/26/2017.
 */

public class Content {

    private String title;
    private String[] url;

    public Content(String[] url, String title){
        this.url = url;
        this.title = title;
    }

    public String[] getURL(){ return url; }
    public String getTitle(){ return title; }

}
