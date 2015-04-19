package com.pekam.entities;


import javax.persistence.*;
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
@Table(name="tblTracks")
@NamedQuery(name="TblTracks.findAll", query="SELECT t FROM TblTracks  t")
public class TblTracks implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;
	
	@Column(nullable=false)
	private Timestamp date ;
	
	private String descr="Track Description";
	private String name="track";
	//private int userid;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="idTblUser",nullable=false)
	private TblUser tbluser;
	
	
	
//	@JoinTable(name="id",referencedColumnName="idtrack", insertable=false, updatable=false)
	@OneToMany(targetEntity=TblGps.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="tbltrack" )
	private List<TblGps> tblgps= new ArrayList<TblGps>();

	
	public TblTracks() {
		
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


	public String getDescr() {
		return this.descr;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
//
//	@Column(nullable=false)
//	public int getUserid() {
//		return this.userid;
//	}

	public void setTblUser(TblUser tblUser) {
		this.tbluser = tblUser;
	}

	public TblUser getTblUser() {
		return this.tbluser;
	}

//	public void setUserid(int userid) {
//		this.userid = userid;
//	}

	public void setTblgps (List<TblGps> tblgps)
	{
	 this.tblgps=tblgps;	
	}

	public List<TblGps> getTblgps ()
	{
	 return this.tblgps;	
	}
	
}