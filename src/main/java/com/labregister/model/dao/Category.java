package com.labregister.model.dao;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy="category")
	private Set<Item> items;
	
	@Column(name= "last_update")
	private LocalDate lastUpdate;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "attribute_1")
	private String attribute1;
	
	@Column(name= "attribute_2")
	private String attribute2;
	
	@Column(name= "attribute_3")
	private String attribute3;


	 @PrePersist
	  protected void onCreate() {
		 this.lastUpdate = LocalDate.now();
	  }
	  @PreUpdate
	  protected void onUpdate() {
	    this.lastUpdate = LocalDate.now();
	  }
	
	
}
