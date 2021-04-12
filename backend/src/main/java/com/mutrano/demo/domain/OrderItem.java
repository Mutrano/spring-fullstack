package com.mutrano.demo.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_order_item")
public class OrderItem {
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	public OrderItem() {
	}
	
	public OrderItem(Order order,Product product,Double discount, Integer quantity, Double price) {
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
		this.id.setOrder(order);
		this.id.setProduct(product);
	}
	public Order getOrder() {
		return id.getOrder();
	}
	public Product getProduct() {
		return id.getProduct();
	}
	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}