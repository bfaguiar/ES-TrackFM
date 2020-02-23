package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistChart{
    private Artists artists;

    public Artists getArtists() {
        return this.artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}

