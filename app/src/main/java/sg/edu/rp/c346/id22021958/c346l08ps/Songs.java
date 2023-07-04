package sg.edu.rp.c346.id22021958.c346l08ps;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NonNls;

public class Songs {

    private int id;
    private String title;
    private String name;
    private int year;
    private int stars;

    public Songs (int id, String title, String name, int year, int stars){
        this.id = id;
        this.title = title;
        this.name = name;
        this.year = year;
        this.stars = stars;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getStars(){
        return stars;
    }

    @NonNull
    @Override
    public String toString(){return id + "\n" + title + "\n" + name + "\n"
    + year + "\n" + stars + "\n"}
}
