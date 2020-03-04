package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class DateTrack {

	private @Getter @Setter String uts;
	@JsonProperty("#text")
	private @Getter @Setter String text;
	
}
