package com.wiem.store.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Oorder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int od_id;
	private Double od_shipping_cost;
	private String od_payment_first_name;
	private String od_payment_last_name;
	private String od_payment_address;
	private String od_payment_phone;
	private String od_payment_postal_code;
	  @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

    @ManyToMany
    @JoinTable(
        name = "order_item",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

}
