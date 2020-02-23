package es.labproj.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artists {

    private List<Artist> artist;

    public List<Artist> getArtists() {
        return this.artist;
    }

    public void setArtists(List<Artist> artists) {
        this.artist = artists;
    }

}