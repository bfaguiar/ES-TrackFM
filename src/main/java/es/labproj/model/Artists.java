package es.labproj.model;

import java.util.List;

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