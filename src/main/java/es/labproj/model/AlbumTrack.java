package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class AlbumTrack {

	private @Getter @Setter String mbid;
	@JsonProperty("#text")
	private @Getter @Setter String text;
	
}
