package com.tourism.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import org.hibernate.validator.constraints.Length;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_id")
	protected Long User_id;		

	@Column(name = "name")
	@NotBlank(message = "Name is mandatory")
	protected String name;	
	
	@Column(name = "phoneNumber",length = 10, unique = true)
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;



	@Email
	@Column(name="email")
	protected String email;
		
	@Column(name="password")
	private String password;
	
	@Column(name = "city")
	@NotNull
	private String city;
	
	@Column(name = "district")
	@NotNull
	private String district;
	

	@Column(name = "state")
	@NotNull
	//@Length(min = 2, max = 10)
	private String state;
	
	//@Column(name = "zip" , length = 6)
	@NotNull
	private int zip;

	  @OneToMany(
				cascade = CascadeType.ALL,
				mappedBy = "userjoin",
				fetch = FetchType.EAGER
		)
		Set<Booking> bookings;
		
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Long user_id, @NotBlank(message = "Name is mandatory") String name, 
			String phoneNumber, String gender, @Email String email, String password, @NotNull String city,
			@NotNull String district, @NotNull String state,
			@NotNull int zip, Set<Booking> bookings) {
		super();
		User_id = user_id;
		this.name = name;

		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.city = city;
		this.district = district;
		this.state = state;
		this.zip = zip;
		this.bookings = bookings;
	}



	public Long getUser_id() {
		return User_id;
	}



	public void setUser_id(Long user_id) {
		User_id = user_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}






	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
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



	public Set<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}



}
