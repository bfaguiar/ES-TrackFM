package es.labproj.trackfm.dbcontroller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.labproj.trackfm.model.recenttracks.Track;


@Repository
public interface RecentTracksRepository extends CrudRepository<Track, String> {
    
}

