package es.labproj.model;

import java.util.List;

public class RecentTracks {

	private List<Tracks> track;

	public List<Tracks> getTrack() {
		return this.track;
	}

	public void setTracks(List<Tracks> tracks) {
		this.track = tracks;
	}

	@Override
	public String toString() {
		return "RecentTracks [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
