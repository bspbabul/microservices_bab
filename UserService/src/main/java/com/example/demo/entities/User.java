package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "micro_user")
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private String userid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "E_MAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> rating;
}
