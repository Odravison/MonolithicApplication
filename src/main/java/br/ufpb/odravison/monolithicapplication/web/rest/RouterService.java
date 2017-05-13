package br.ufpb.odravison.monolithicapplication.web.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufpb.odravison.monolithicapplication.models.CallHistory;

@Service
public class RouterService {
	
	@Autowired
	private GetService getService;
	private final char GET_STEP = '1';
	
	@Autowired
	private PostService postService;
	private final char POST_STEP = '2';
	
	@Autowired
	private DeleteService deleteService;
	private final char DELETE_STEP = '3';
	
	@Autowired
	private PutService putService;
	private final char PUT_STEP = '4';
	
	public ResponseEntity<List<CallHistory>> performRouter(String stepsReceived){
		
		List<CallHistory> resultList = new LinkedList<>();
		
		ResponseEntity<List<CallHistory>> result = null;
		
		 
		
		char [] steps = stepsReceived.toCharArray();
		
		for (char step : steps){
			if (step == this.GET_STEP){
				HttpStatus httpStatus = getService.receivingAGet().getStatusCode();
				CallHistory callHistory = new CallHistory("GET_METHOD", httpStatus);
				resultList.add(callHistory);
			}
			
			else if (step == this.POST_STEP){
				HttpStatus httpStatus = postService.receivingAPost().getStatusCode();
				CallHistory callHistory = new CallHistory("POST_METHOD", httpStatus);
				resultList.add(callHistory);
			}
			
			else if(step == this.DELETE_STEP){
				HttpStatus httpStatus = deleteService.receivingADelete().getStatusCode();
				CallHistory callHistory = new CallHistory("DELETE_METHOD", httpStatus);
				resultList.add(callHistory);
			}
			
			else if(step == this.PUT_STEP){
				HttpStatus httpStatus = putService.receivingAPut().getStatusCode();
				CallHistory callHistory = new CallHistory("PUT_METHOD", httpStatus);
				resultList.add(callHistory);
			}
			
			else {
				resultList.add(new CallHistory("UNKNOWN_METHOD", HttpStatus.BAD_REQUEST));
			}
			
		}
		
		result = new ResponseEntity<List<CallHistory>>(resultList, HttpStatus.OK);
		
		return result;
	}

}
