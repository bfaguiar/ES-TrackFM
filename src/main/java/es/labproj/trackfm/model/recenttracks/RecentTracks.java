package es.labproj.trackfm.model.recenttracks;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class RecentTracks {

	@Id
	@GeneratedValue
	private long Id;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "recentTracks")
	private @Getter @Setter List<Track> track;

	@OneToOne
	private TracksChart tracksChart;
	
}