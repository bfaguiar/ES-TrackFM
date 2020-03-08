package es.labproj.model;

import lombok.Getter;
import lombok.Setter;

public class Track {
	
	private @Getter @Setter ArtistTrack artist;
	private @Getter @Setter String name;
	private @Getter @Setter AlbumTrack album;
	private @Getter @Setter DateTrack date;
	
}



