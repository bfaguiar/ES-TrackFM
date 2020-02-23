package es.labproj.api;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import es.labproj.model.*;

@Component // bean: Component("apiBean bean")
@RestController
public class CallRestAPI {
	
	static RestTemplate restTemplate = new RestTemplate();
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/home/",  method = RequestMethod.GET)
	public ResponseEntity<List<Artist>> Home() {
		
		ResponseEntity<Artists> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<Artists>() {}
        );
        


		System.out.println("\n\n\n\nola\n\n\ns");
        Artists body = responses.getBody();
        List<Artist> artist = body.getArtists();
        
		System.out.println(artist.get(0).name);
		return new ResponseEntity<List<Artist>>(artist, HttpStatus.OK);
		
	}
	
	// API key = 46d61d429e1fcddb75d6b42038a671f5
	// shared secret = 2cf0450de35bbffcb265741051443ace
		
}