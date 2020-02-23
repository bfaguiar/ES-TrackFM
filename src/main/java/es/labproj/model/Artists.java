package es.labproj.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Artists {

   private List<Artist> artist;

    public List<Artist> getArtist() {
        return this.artist;
    }

    @Override
    public String toString() {
        return "{" +
            " artist='" + getArtist() + "'" +
            "}";
    }
    public void setArtists(List<Artist> artists) {
        this.artist = artists;
    }

}