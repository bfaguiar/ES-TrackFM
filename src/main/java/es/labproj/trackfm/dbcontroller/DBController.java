package es.labproj.trackfm.dbcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import es.labproj.trackfm.dbcontroller.client.CallRestService;
import es.labproj.trackfm.model.recenttracks.Track;

@Component
@ComponentScan({"es.labproj.trackfm.dbcontroller.client"})
public class DBController {

    @Autowired
    CallRestService restService;

    @Autowired
    TracksChartRepository tracksChartReposity;

    @Autowired
    RecentTracksRepository recentTracksRepository;

    @Autowired
    TrackRepository trackReposity;

    @Autowired
    DateTrackRepository dateTrackRepository;

    @Autowired
    ArtistTrackRepository artistTrackRepository;

    @Autowired
    AlbumTrackRepository albumTrackRepository;

    
    public void addTracksChart() {

        tracksChartReposity.save(restService.getMostRecentTracks());
        System.out.println("TracksChart added");

    }
    

    //@Scheduled(fixedRate=1000)
    public void addRecentTracks() {

        recentTracksRepository.save(restService.getMostRecentTracks().getRecenttracks());
        System.out.println("RecentTracks added");

    }

    public void addTracks() {

        List<Track> tracks = restService.getMostRecentTracks().getRecenttracks().getTrack();
        tracks.forEach(t -> {
            if (t != null) {
                trackReposity.save(t);
            }
        });

        System.out.println("Tracks Added");

    }

    public void addDateTrack() {

        List<Track> dateTracks = restService.getMostRecentTracks().getRecenttracks().getTrack();
        dateTracks.forEach(t -> {
            if (t != null) {
                dateTrackRepository.save(t.getDate());
            }
        });
        System.out.println("Date Added");
    }

    public void addArtistTrack() {

        List<Track> tracks = restService.getMostRecentTracks().getRecenttracks().getTrack();
        tracks.forEach(t -> {
            if (t != null) {
                artistTrackRepository.save(t.getArtist());
            }
        });

        System.out.println("artists added");
    }

    public void addAlbumTrack() {

        List<Track> tracks = restService.getMostRecentTracks().getRecenttracks().getTrack();
        tracks.forEach(t -> {
            if (t != null) {
                albumTrackRepository.save(t.getAlbum());
            }
        });

        System.out.println("Album added");
    }

}

