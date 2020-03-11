package es.labproj.trackfm.model.recenttracks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

//@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TracksChart {
	
//	@Id
	//@GeneratedValue
	private @Getter @Setter RecentTracks recenttracks;

}	