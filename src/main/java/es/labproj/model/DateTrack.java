package es.labproj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateTrack {
	private String uts;
	@JsonProperty("#text")
	private String text;
	
	public String getUts() {
		return uts;
	}
	public void setUts(String uts) {
		this.uts = uts;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
