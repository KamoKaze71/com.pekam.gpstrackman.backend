package com.pekam.entities;


import javax.persistence.*;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tblGps database table.
 * 
 */
@Entity
@Table(name="tblGps")
@NamedQuery(name="TblGps.findAll", query="SELECT t FROM TblGps t")

public class TblGps implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;
	
	@Column(nullable=false)
	private Timestamp date ;
	
	private String descr;
	@Column(nullable=false, precision=53)
	private double lat;
	@Column(nullable=false, precision=53)
	private double lng;
	
	private String provider;
	private String deviceID;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTblTracks",nullable=false)
	private TblTracks tbltrack;


	public TblGps() {
		
		this.date= new Timestamp(new Date().getTime());

	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public String getDeviceID() {
		return this.deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}


	
	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat =lat;
	}



	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng ) {
		this.lng = lng;
	}

	public TblTracks getTblTrack() {
		return this.tbltrack;
	}

	public void setTblTrack(TblTracks tbltrack ) {
		this.tbltrack = tbltrack;
	}
	 

}