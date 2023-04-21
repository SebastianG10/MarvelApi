package com.juansebastiangarciahincapie.marvelapi.service.marvel.model;

import java.util.ArrayList;
import java.util.Date;

public class Result {
    public int id;
    public String name;
    public String description;
    public Date modified;
    public Thumbnail thumbnail;
    public String resourceURI;
    public Comics comics;
    public Series series;
    public Stories stories;
    public Events events;
    public ArrayList<Url> urls;
}
