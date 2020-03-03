package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TracksChart {
	
	private RecentTracks recenttracks;

	public RecentTracks getRecenttracks() {
		return this.recenttracks;
	}

	public void setRecenttracks(RecentTracks recentTracks) {
		this.recenttracks = recentTracks;
	}
	
}
