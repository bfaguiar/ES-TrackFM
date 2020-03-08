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
	
	//@Scheduled(fixedRate = 5000)
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/recenttracks/",  method = RequestMethod.GET)
	public ResponseEntity<List<Track>> RecentTracks(@RequestParam("name") String name)
	{
		ResponseEntity<TracksChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=user.getRecentTracks&user="+name+"&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<TracksChart>() {});
		
		List<Track> tracks = responses.getBody().getRecenttracks().getTrack();
		
		return new ResponseEntity<List<Track>>(tracks , HttpStatus.OK);
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/userinfo/", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> UserDetails(@RequestParam("name") String name)
	{
		ResponseEntity<UserDetailsChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=user.getinfo&user="+name+"&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<UserDetailsChart>() {}
        );
		return new ResponseEntity<UserDetails>(responses.getBody().getUser(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/userartists/", method = RequestMethod.GET)
	public ResponseEntity<List<ArtistT>> UserArtists(@RequestParam("name") String name)
	{
		ResponseEntity<TopChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user="+name+"&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<TopChart>() {}
        );
		return new ResponseEntity<List<ArtistT>>(responses.getBody().getTopartists().getArtist(), HttpStatus.OK);
	}
	// API key = 46d61d429e1fcddb75d6b42038a671f5
	// shared secret = 2cf0450de35bbffcb265741051443ace
		
}

