package com.tourism.demo.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="place_id")
	 private long place_id;
	
	@Column(name ="place_name")
	private String place_name;
	
	@Column(name = "street")
	@NotNull
	private String street;
	
	@Column(name = "district")
	@NotNull
	private String district;
	

	@Column(name = "state")
	@NotNull
	@Length(min = 2, max = 2)
	private String state;
	
	@Column(name = "zip" , length = 6)
	@NotNull
	@Pattern(regexp="(^$|[0-9]{6})")
	private int zip;

	
	  @ManyToOne(targetEntity=Booking.class,fetch=FetchType.EAGER)
	  
	  @JoinColumn(name="tour_bookingid",insertable=false,updatable=false) private
	  Booking bookingjoin;
	 
	

	/*
	 * @OneToMany(cascade = CascadeType.ALL,mappedBy = "placejoin",fetch
	 * =FetchType.EAGER) private Set<Hotel> hotels;
	 * 
	 */
		@ManyToMany(
				cascade = CascadeType.ALL,
				mappedBy = "placejoin",
				fetch = FetchType.EAGER
		)
		private Set<TourPackage> packages;
		
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Place(long place_id, String place_name, @NotNull String street, @NotNull String district,
			@NotNull @Length(min = 2, max = 2) String state, @NotNull @Pattern(regexp = "(^$|[0-9]{6})") int zip,
			Set<Hotel> hotels) {
		super();
		this.place_id = place_id;
		this.place_name = place_name;
		this.street = street;
		this.district = district;
		this.state = state;
		this.zip = zip;

	}


	public long getPlace_id() {
		return place_id;
	}


	public void setPlace_id(long place_id) {
		this.place_id = place_id;
	}


	public String getPlace_name() {
		return place_name;
	}


	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}




	
}

