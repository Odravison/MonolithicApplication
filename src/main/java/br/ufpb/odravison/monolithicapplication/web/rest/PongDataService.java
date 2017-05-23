package br.ufpb.odravison.monolithicapplication.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongDataService {
    
    @Autowired
    private PingDataService pingDataService;
    
    @GetMapping("/pong-data")
    public ResponseEntity<HttpStatus> pongData(){
        
        return ResponseEntity.ok(HttpStatus.OK); 
        
    }
    
    @GetMapping("/pong-data/pong-data-from-ping")
    public ResponseEntity<HttpStatus> pongDataFromPing(){
        
        return pingDataService.pingData();
    }

}
