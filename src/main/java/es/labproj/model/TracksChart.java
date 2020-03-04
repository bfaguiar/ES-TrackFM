package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TracksChart {
	
	private @Getter @Setter RecentTracks recenttracks;
	
}
