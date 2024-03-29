package com.example.mymoviecatalog.Class;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie implements Parcelable {

    private int id;
    private String name;
    private String description;
    private String photo;
    private String popularity;
    private String releasedate;
    final String urlPhoto = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/";


    public String getReleasedate() { return releasedate; }

    public void setReleasedate(String releasedate) { this.releasedate = releasedate; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPopularity() { return popularity; }

    public void setPopularity(String popularity) { this.popularity = popularity; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.popularity);
        dest.writeString(this.releasedate);
    }


    public Movie(Parcel in) {
        this.photo = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.popularity = in.readString();
        this.releasedate= in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(){

    }

    public Movie(JSONObject object) {

        try {

            int id = object.getInt("id");
            String name = object.getString("original_title");
            String description = object.getString("overview");
            String popularity = object.getString("popularity");
            String releasedate = object.getString("release_date");
            String photo = object.getString("poster_path");

            this.id = id;
            this.name = name;
            this.description = description;
            this.popularity = popularity;
            this.releasedate = releasedate;
            this.photo = urlPhoto + photo;



        } catch (Exception e) {
            e.printStackTrace();
        }




    }



}
