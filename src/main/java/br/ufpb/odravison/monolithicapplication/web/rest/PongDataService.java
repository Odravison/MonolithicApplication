package br.ufpb.odravison.monolithicapplication.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongDataService {
    
    @Autowired
    private PingDataService pingDataService;
    
    private Logger logger = LoggerFactory.getLogger(PongDataService.class);
    
    @GetMapping("/pong-data")
    public ResponseEntity<HttpStatus> pongData(){
        
        logger.info("Getting /pong-data");
        
        return ResponseEntity.ok(HttpStatus.OK); 
        
    }
    
    @GetMapping("/pong-data/pong-data-from-ping")
    public ResponseEntity<HttpStatus> pongDataFromPing(){
        
        logger.info("Getting /pong-data-from-ping");
        
        return pingDataService.pingData();
    }

}
