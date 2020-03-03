package es.labproj.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import es.labproj.model.*;

@Component // bean: Component("apiBean bean")
@RestController
public class CallRestAPI {
	
	static RestTemplate restTemplate = new RestTemplate();
	private static final Logger log = LoggerFactory.getLogger(CallRestAPI.class);
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/artists/",  method = RequestMethod.GET)
	public ResponseEntity<List<Artist>> Home() {
		
		ResponseEntity<ArtistChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<ArtistChart>() {}
        );
        List<Artist> artist = responses.getBody().getArtists().getArtist()  ;

                
		return new ResponseEntity<List<Artist>>(artist, HttpStatus.OK);
		
	}
	
	@Scheduled(fixedRate = 5000)
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/user/",  method = RequestMethod.GET)
	public ResponseEntity<List<Tracks>> User()
	{
		ResponseEntity<TracksChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=user.getRecentTracks&user=buaguiar&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<TracksChart>() {});
		
		List<Tracks> tracks = responses.getBody().getRecenttracks().getTrack();	
		log.info("Tou cá");
		
		
		return new ResponseEntity<List<Tracks>>(tracks , HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/artist/", method = RequestMethod.GET)
	public ResponseEntity<ArtistDetails> Details(@RequestParam("name") String name)
	{
		ResponseEntity<DetailsChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist="+name+"&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<DetailsChart>() {}
        );
	
		
		return new ResponseEntity<ArtistDetails>(responses.getBody().getArtist(), HttpStatus.OK);
	}
	// API key = 46d61d429e1fcddb75d6b42038a671f5
	// shared secret = 2cf0450de35bbffcb265741051443ace
		
}