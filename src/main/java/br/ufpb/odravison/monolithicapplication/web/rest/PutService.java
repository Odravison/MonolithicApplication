package br.ufpb.odravison.monolithicapplication.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.odravison.monolithicapplication.models.CallHistory;

@RestController
@RequestMapping("/api")
public class PutService {
	
	@Autowired
	private RouterService routerService;
	
	@PutMapping("/perform-a-put")
	public ResponseEntity<List<CallHistory>> performAPut(@RequestParam(value="stepsReceived") String stepsReceived){
		
		return routerService.performRouter(stepsReceived); 
		
	}
	
	public ResponseEntity<HttpStatus> receivingAPut(){
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
