package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistTrack {
	private String mbid;
	@JsonProperty("#text")
	private String text;
	
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
