package core;

import java.io.Serializable;

import util.PetCollection;

public class Order implements Serializable, PetCollection {

	/**
	 * 
	 */
	private static final long serialVersionUID = 974302513583269624L;
	private Integer orderId;
	private Integer petId;
	private Integer quantity;
	private Status status;
	private static int count=0;
	public Order(int petId, int quantity) {
		orderId=++count;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.valueOf("IN_PROCESS");
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]\n";
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	
	
	
	
}
