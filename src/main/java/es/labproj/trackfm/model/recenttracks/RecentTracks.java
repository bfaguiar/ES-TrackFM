package es.labproj.trackfm.model.recenttracks;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Entity
@ToString
public class RecentTracks {

//	@Id
//	@GeneratedValue
	private @Getter @Setter List<Track> track;
	
}