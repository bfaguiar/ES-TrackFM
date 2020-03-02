package es.labproj.api;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@RestController
public class CallRestAPI {
	
  static RestTemplate restTemplate = new RestTemplate();

  static int asd = 0;

  private static final Logger log = LoggerFactory.getLogger(CallRestAPI.class);
   
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/home/")
  public ResponseEntity<String> Home() {

    String html = getStrMenu();
    return new ResponseEntity<>(html, HttpStatus.OK);
  }
	
	@CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value="/artists/",  method = RequestMethod.GET)
  @Scheduled(fixedRate = 1000)
	public ResponseEntity<String> Artists() {
		log.info("log++");
		ResponseEntity<ArtistChart> responses = restTemplate.exchange(
				"http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=46d61d429e1fcddb75d6b42038a671f5&format=json"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<ArtistChart>() {}
        );
        
    List<Artist> artist = responses.getBody().getArtists().getArtist()  ;
    String html = getStr(artist);
    return new ResponseEntity<String>(html, HttpStatus.OK);

  }

      @CrossOrigin(origins = "http://localhost:3000")
      @RequestMapping(value="/artist/", params = "name", method = RequestMethod.GET)
      public ResponseEntity<String> Artist (@RequestParam("name") String n) {
        String html = "ola." + n;
        return new ResponseEntity<String>(html, HttpStatus.OK);
      }

      // avoids html overload in function Artists()
      public String getStr(List<Artist> artist) {
        asd++;
        String html = "<!DOCTYPE html>" +
        "<html lang='en'>" +
        "<head>" +
          "<title>Trackfm</title>" +
          "<meta charset='utf-8'>" +
          "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
          "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>"+
          "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>"+
          "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>"+
        "</head>"+
        "<body>"+
        "<div class='container'>"+
          "<h2>Artist Charts</h2>"+
          "<h2>" + Integer.toString(asd) + "</h2> " +
          "<p>Displaying the top 50 artists in chart!</p>"  +          
          "<table class='table table-striped'>"+
            "<thead>"+
              "<tr>"+
                "<th>no</th>"+
                "<th> Name </th>" +
                "<th>Playcount</th>"+
                "<th>Listeners</th>"+
              "</tr>"+
            "</thead>"+
            "<tbody> ";

        for(int i=0; i<artist.size();i++) {

            int j = i+1;
            html += "<tr>"      +
            "<td>" +j+ "</td>"  +
            "<td> <a href='http://localhost:8080/artist/?name=" + artist.get(i).getName().replace(" ", "+") + "'>" 
                                                                + artist.get(i).getName() + "</a> </td>"    +
            "<td>"  + NumberFormat.getNumberInstance(Locale.US).format(     // this will add semicollon
                      Integer.parseInt(artist.get(i).getPlaycount())
                      ).toString() + 
            "</td>" +
            "<td>"  + NumberFormat.getNumberInstance(Locale.US).format(     // this will add semicollon
                      Integer.parseInt(artist.get(i).getListeners())
                      ).toString() + 
            "</td>"+
            "</tr>";  
    
        }
        
        html += "</tbody>";
        html += "</table>";
        html += "</div>"  ;
  
        html += "</body>";
        html += "</html>";
        return html;
      }
    
      public String getStrMenu() {
        String html = "<!DOCTYPE html>" +
        "<html lang='en'>" +
        "<head>" +
          "<title>Trackfm</title>" +
          "<meta charset='utf-8'>" +
          "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
          "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>"+
          "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>"+
          "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>"+
        "</head>"+
        "<body>"+
        "<div class='container' align='center'>"+
        "<h2> Trackfm </h2>" +
        "<div class='card' style='width: 18rem;'>" +
        "<ul class='list-group list-group-flush'>" +
          "<li class='list-group-item'> <a href='http://localhost:8080/artists/'> Go to artists chart </a> </li>" +
          "<li class='list-group-item'> <a href='http://localhost:8080/artists/'> Go to artists chart </a> </li>" +
          "<li class='list-group-item'> <a href='http://localhost:8080/artists/'> Go to artists chart </a> </li>" +
        "</ul>" +
      "</div>" +
      "</div>" +
      "</body>" +
      "</html>";
      return html;
      }


	// API key = 46d61d429e1fcddb75d6b42038a671f5
	// shared secret = 2cf0450de35bbffcb265741051443ace
  // spring web = https://www.baeldung.com/category/spring-web/
  // spring web MVC Basics = https://www.baeldung.com/category/spring-web/tag/spring-mvc-basics/
  // Vogella JPA base de dados 
  // Prime Faces.. java summer server faces.
} 