package com.wiem.store.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cat_id;
	private String cat_name;
	private String cat_description;
	private String cat_image;
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

	


}
