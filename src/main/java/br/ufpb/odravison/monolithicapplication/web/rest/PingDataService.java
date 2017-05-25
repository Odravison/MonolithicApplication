package br.ufpb.odravison.monolithicapplication.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingDataService {
    
    @Autowired
	private PongDataService pongDataService;
    
    private Logger logger = LoggerFactory.getLogger(PingDataService.class);

    @GetMapping("/lvl1")
	public ResponseEntity<HttpStatus> getDataLvl1(){
        
        logger.info("Getting /ping-data");
		
		return ResponseEntity.ok(HttpStatus.OK); 
		
	}
	
	@GetMapping("/lvl2")
	public ResponseEntity<HttpStatus> getDataLvl2(){
	    
	    logger.info("Getting /ping-data-from-pong");
	    
	    return pongDataService.pongDataLvl1();
	}
	
	@GetMapping("/lvl3")
    public ResponseEntity<HttpStatus> getDataLvl3(){
        
        logger.info("Getting /ping-data-from-pong");
        
        return pongDataService.pongDataLvl2();
    }

}
