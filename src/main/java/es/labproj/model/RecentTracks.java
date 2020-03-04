package es.labproj.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RecentTracks {

	private @Getter @Setter List<Tracks> track;
	
}
