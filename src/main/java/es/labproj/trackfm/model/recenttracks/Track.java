package es.labproj.trackfm.model.recenttracks;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Track {
	
	@Id
	@GeneratedValue
	private long Id;

	private @Getter @Setter String mbid;

	@OneToOne(cascade=CascadeType.ALL, mappedBy = "track" )
	private @Getter @Setter ArtistTrack artist;

	private @Getter @Setter String name;

	@OneToOne(cascade=CascadeType.ALL, mappedBy = "track")
	private @Getter @Setter AlbumTrack album;

	@OneToOne(cascade=CascadeType.ALL, mappedBy = "track") 
	private @Getter @Setter DateTrack date;

	@ManyToOne
	private RecentTracks recentTracks;
	
	
}		



  
 