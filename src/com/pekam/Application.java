package com.pekam;


import com.pekam.entities.TblGps;
import com.pekam.entities.TblTracks;
import com.pekam.entities.TblUser;
import com.pekam.jpa.TblGpsRepository;
import com.pekam.jpa.TblTracksRepository;
import com.pekam.jpa.TblUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
@ComponentScan("com.pekam")
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes =AppConfig.class)
public class Application {

	public static ConfigurableApplicationContext ctx;
	public static TblGpsRepository DataRepository;
	public static TblTracksRepository DataRepositoryTracks;
	public static TblUserRepository DataRepositoryUser;
	
    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext ctx= SpringApplication.run(Application.class, args);
    	
    	DataRepository=ctx.getBean(TblGpsRepository.class);
    	DataRepositoryTracks=ctx.getBean(TblTracksRepository.class);
    	DataRepositoryUser = ctx.getBean(TblUserRepository.class);
    	
    	populateDB();
    }
    
    
    private static void populateDB()
    
        {
    	
    	TblUser user = new TblUser();
    	user.setName("peter");
    	user.setSurame("kamitz");
    	
    	
    	List<TblTracks> trackList= new ArrayList<TblTracks>();
    	
    	TblTracks track = new TblTracks();
    	track.setDescr("MyTrackDescription");
    	track.setName("MyTrackeName");
    	track.setTblUser(user);

    	
    	List<TblGps> gpsList= new ArrayList<TblGps>();
    	TblGps gps1=new TblGps();
    	gps1.setTblTrack(track);
    	gpsList.add(gps1);
    	
    	TblGps gps7=new TblGps();
    	gps7.setTblTrack(track);
    	gpsList.add(gps7);
    	
    	TblGps gps8=new TblGps();
    	gps8.setTblTrack(track);
    	gpsList.add(gps8);
    	
    	TblGps gps4=new TblGps();
    	gps4.setTblTrack(track);
    	gpsList.add(gps4);
    	
    	TblGps gps5=new TblGps();
    	gps5.setTblTrack(track);
    	gpsList.add(gps5);
    	
    	TblGps gps6=new TblGps();
    	gps6.setTblTrack(track);
    	gpsList.add(gps6);
    
    	track.setTblgps(gpsList);
    	trackList.add(track);
    	user.setTbltracks(trackList);
       	
    	DataRepositoryUser.save(user);
    	
    	// save a couple of customers
//    	DataRepository.save(new TblGps());
//    	DataRepository.save(new TblGps());
//    	DataRepository.save(new TblGps());
//    	DataRepository.save(new TblGps());
//    	DataRepository.save(new TblGps());
//    	
    	   // fetch all customers
        Iterable<TblGps> gps = DataRepository.findAll();
        Iterable<TblTracks> tracks1 = DataRepositoryTracks.findAll();
       
      
        
        System.out.println("-------------------------------");
        for (TblTracks tracke : tracks1) {
            System.out.println("Track id: "+ tracke.getId());
        }
        System.out.println("-------------------------------");
        
        
        
        
//        TblTracks tbl= new TblTracks();
//    	List<TblGps> gps1= new ArrayList<TblGps>();
//    	gps1.add(new TblGps());
//    	gps1.add(new TblGps());
//    	gps1.add(new TblGps());
//    	tbl.setGps(gps1);
    	
 //   	DataRepositoryTracks.save(tbl);
        
        System.out.println("-------------------------------");
        for (TblGps gpsd : gps) {
            System.out.println(gpsd.getId());
        }
        System.out.println();

        // fetch an individual customer by ID
        TblGps gps2 = DataRepository.findOne(1L);
      
        System.out.println("--------------------------------");
        System.out.println(gps2);
        System.out.println();

        // fetch Coord by id
        TblGps gps3 = DataRepository.findById(1);
     
        System.out.println("--------------------------------------------");
        System.out.println(gps3);
        
    	
    	
    	
    }
}
