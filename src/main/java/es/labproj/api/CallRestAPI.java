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
	@RequestMapping(value="/artists/",  method = RequestMethod.GET)
	public ResponseEntity<String> Home() {
		
		ResponseEntity<ArtistChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<ArtistChart>() {}
        );
        List<Artist> artist = responses.getBody().getArtists().getArtist()  ;

        String html = "<table border='1' style='width:100%'> "+
                        "<tr>" +
                        "<th> no</th>" +
                       " <th>Name</th>" +
                        "<th>Playcount</th>" +
                        "<th>Listeners</th>" +
                        "</tr>   ";
               for(int i=0; i<artist.size();i++) {
                   int j = i+1;
                    html+="<tr>" +
                        "<td>"+j+"</td>"+
                        "<td> <a href='http://localhost:8080/artist/?name=" + artist.get(i).getName().replace(" ", "+")+ "'>" +artist.get(i).getName()+"</a> </td>"+
                        "<td>"+artist.get(i).getPlaycount()+"</td>"+
                        "<td>"+artist.get(i).getListeners()+"</td>"+
                    "</tr>";               
               }         
                html+="</table>";
                
		return new ResponseEntity<String>(html, HttpStatus.OK);
		
	}
	
	// API key = 46d61d429e1fcddb75d6b42038a671f5
	// shared secret = 2cf0450de35bbffcb265741051443ace
		
}