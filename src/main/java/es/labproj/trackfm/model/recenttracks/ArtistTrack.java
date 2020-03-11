package es.labproj.trackfm.model.recenttracks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

//@Entity
public class ArtistTrack {
	
	//@Id
	//@GeneratedValue
	private @Getter @Setter String mbid;
	@JsonProperty("#text")
	private @Getter @Setter String text;
	
}

