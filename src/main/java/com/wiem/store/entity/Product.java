package com.wiem.store.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prod_id;
	private String prod_name;
	private String prod_description;
	private Double prod_price;
	private int prod_quantity;
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	@ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<Oorder> orders;
	
}
