package es.labproj.trackfm.model.recenttracks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tracks")
public class Track {
	
	@Id
	@GeneratedValue
	private @Getter @Setter String mbid;
	private @Getter @Setter ArtistTrack artist;
	private @Getter @Setter String name;
	private @Getter @Setter AlbumTrack album;
	private @Getter @Setter DateTrack date;
	
	
}



