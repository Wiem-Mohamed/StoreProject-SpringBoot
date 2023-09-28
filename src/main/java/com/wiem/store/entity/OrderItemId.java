package com.wiem.store.entity;

import java.io.Serializable;

import jakarta.persistence.Id;

public class OrderItemId implements Serializable{
	
	private int order_id;
	
	private int product_id;

}
