package es.labproj.trackfm.dbcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.labproj.trackfm.dbcontroller.client.CallRestService;
import es.labproj.trackfm.model.recenttracks.Track;

@Component
public class DBController {

    @Autowired
    CallRestService restService;

    @Autowired
    RecentTracksRepository recentTracksRepository;

    //@Scheduled(fixedRate=1000)
    public void addRecentTracks() {

        List<Track> tracks = restService.getRecentTracks();
        tracks.forEach( t -> {
            if (t != null) {
                recentTracksRepository.save(t);
            }
        });
        System.out.println("Countries added");
    }
}

