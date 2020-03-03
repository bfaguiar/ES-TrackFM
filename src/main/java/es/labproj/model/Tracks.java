package es.labproj.model;

public class Tracks {
	
	private ArtistTrack artist;
	private String name;
	private AlbumTrack album;
	private DateTrack date;
	
	
	public AlbumTrack getAlbum() {
		return album;
	}

	public void setAlbum(AlbumTrack album) {
		this.album = album;
	}

	public DateTrack getDate() {
		return date;
	}

	public void setDate(DateTrack date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtistTrack getArtist() {
		return artist;
	}

	public void setArtist(ArtistTrack artist) {
		this.artist = artist;
	}
	
	
}