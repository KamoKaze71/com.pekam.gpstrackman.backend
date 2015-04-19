/**
 * 
 */
package com.pekam.jpa;

/**
 * @author pk
 *
 */

import com.pekam.*;
import com.pekam.entities.TblGps;
import com.pekam.entities.TblTracks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TblGpsController {
	
	 private static final Logger logger = LoggerFactory.getLogger(TblGpsController.class);

	@RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST , RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD })
	@ResponseBody
	public String allFallback() {
	    return "Fallback for All Requests";
	}
	  
	  @RequestMapping(value="/TblGps/update", method= RequestMethod.POST, consumes = "application/json",produces="application/json")
	  @ResponseBody
	  public TblGps postSingleObject(@RequestBody TblGps gps){
		 
			logger.debug("/TblGps/update: " + gps.getId());
		
			  return Application.DataRepository.save(gps);
		}
	  
//	  @RequestMapping(value="/TblGps/updateArrayList", method=RequestMethod.POST, consumes = "application/json",produces="application/json")
//	  @ResponseBody public ArrayList<TblGps> postArray(@RequestBody ArrayList<TblGps> gps){
//		 
//	
//				  {
//			for (int i = 0; i < gps.size(); i++) {
//				logger.debug("/TblGps/updateList: " + gps.get(i));
//				
//				Application.DataRepository.save(gps.get(i));
//			}
//			  
//				  }
//			  return gps;
//		
//	 }
//  
//	  @RequestMapping(value="/TblGps/updateList", method=RequestMethod.POST, consumes = "application/json",produces="application/json")
//	  @ResponseBody public TblGps[] postArray(@RequestBody TblGps[] gps){
//		 
//	
//				  {
//			for (int i = 0; i < gps.length; i++) {
//				logger.debug("/TblGps/updateList: " + gps[i].getId());
//				
//				Application.DataRepository.save(gps[i]);
//			}
//			  
//				  }
//			  return gps;
//		
//	 }
	
	    @RequestMapping(value="/TblGps/get", method= RequestMethod.GET)
		    public @ResponseBody
		TblGps findById(
	    		   @RequestParam(value="id",defaultValue="1", required=true) long id) {
	    	logger.debug("/TblGps/get: " + id);
	    		return Application.DataRepository.findById(id);
	    }
	    
	    @RequestMapping(value="/TblTracks/get", method= RequestMethod.GET)
	    public @ResponseBody
		TblTracks findById1(
    		   @RequestParam(value="id",defaultValue="1", required=true) long id) {
    	logger.debug("/TblTracks/get: " + id);
    		return Application.DataRepositoryTracks.findById(id);
    }

	    @RequestMapping(value="/TblGps/getList/", method= RequestMethod.GET)
	    public @ResponseBody
		List<TblGps> findAll()
	    {
	    	logger.debug("/TblGps/getList");
	       return 	Application.DataRepository.findAll();
	    }

	    @RequestMapping(value="/Object/getList/", method= RequestMethod.GET)
	    public @ResponseBody
		List<Object> findAllObject()
	    {
	    	logger.debug("/Object/getList/");
	    	List<Object> objects = new ArrayList<Object>();
	    	 
	       return objects	;
	    }
	   
	   
	}


/*
 * 
 * 
 * 
 * import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
 * 
 * //his method response to POST request http://localhost/spring-mvc-json/rest/cont/person
// receives json data sent by client --> map it to Person object
// return Person object as json
@RequestMapping(value="/TblGps/update3/", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE,produces=  MediaType.ALL_VALUE, headers =  "Accept=application/json")
public @ResponseBody TblGps post1( @RequestBody final  TblGps gps) {    
	  
      logger.debug("I am in the controller and got user name: " + gps.getDate().toString());
    System.out.println("save.............."+ gps.getId() + " " + gps.getDescr());
    return Application.DataRepository.save(gps);
}

@RequestMapping(value="/TblGps/update2/", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE,produces= MediaType.ALL_VALUE)
public @ResponseBody String post2( @RequestBody final  String gps) {    

    System.out.println("save.............."+ gps);
//    return Application.DataRepository.save(gps);
    return gps;
}
*/
