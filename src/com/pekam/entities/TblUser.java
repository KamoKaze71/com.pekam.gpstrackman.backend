package com.pekam.entities;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblGps database table.
 * 
 */
@Entity
@Table(name="TblUser")
@NamedQuery(name="TblUser.findAll", query="SELECT t FROM TblUser  t")

public class TblUser implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;
	
	@Column(nullable=false)
	private Timestamp date ;
	private String  loginid="peter.kamitz@gmail.com";
	private String strpwd="1111";
	private String name="Peter";
	private String surname="Kamitz";
	
	
	
	@OneToMany(targetEntity=TblTracks.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="tbluser" )
	//@JoinColumn(name="id",referencedColumnName="userid")
	private List<TblTracks> tbltracks= new ArrayList<TblTracks>();
	
	
//	@OneToMany(targetEntity=TblGps.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="tbluser" )
////	@JoinColumn(name="id",referencedColumnName="userid")
//	private List<TblGps> tblgps = new ArrayList<TblGps>();
	
	public TblUser() {
		
		date= new Timestamp(new Date().getTime());
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


	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	} 

	public void setSurame(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return this.surname;
	}

//	public List<TblGps> getGps (List<TblGps> tblgps)
//	{
//	 return this.tblgps;	
//	}
//	public void setTblgps (ArrayList<TblGps> tblgps)
//	{
//	 this.tblgps=tblgps;	
//	}
	
	public List<TblTracks> getTracks ()
	{
	 return this.tbltracks;	
	}
	public void setTbltracks (List<TblTracks>tbltracks)
	{
	 this.tbltracks=tbltracks;	
	}
	
}