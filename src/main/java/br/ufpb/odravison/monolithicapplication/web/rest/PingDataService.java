package br.ufpb.odravison.monolithicapplication.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingDataService {
    
    @Autowired
	private PongDataService pongDataService;

    @GetMapping("/ping-data")
	public ResponseEntity<HttpStatus> pingData(){
		
		return ResponseEntity.ok(HttpStatus.OK); 
		
	}
	
	@GetMapping("/ping-data/ping-data-from-pong")
	public ResponseEntity<HttpStatus> pingDataFromPong(){
		
	    return pongDataService.pongData();
	}

}
