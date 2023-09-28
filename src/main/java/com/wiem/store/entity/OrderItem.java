package com.wiem.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItem {
	@Id
	private int order_id;
	@Id
	private int product_id;
	private int quantity;

}
