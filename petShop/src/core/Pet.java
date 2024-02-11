package core;

import java.io.Serializable;
import java.util.Comparator;

import util.PetCollection;

public class Pet implements Serializable,PetCollection {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -212106188389023316L;
	private int petId;
	 private String name;
	 private Category type;
	 private Double unitPrice;
	 private Integer stocks;
	 private static int count;
	 static {
		 count=1000;
	 }
	public Pet(String name, Category type, Double unitPrice, Integer stocks) {
		petId=++count;
		this.name = name;
		this.type = type;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", type=" + type + ", unitPrice=" + unitPrice + ", stocks="
				+ stocks + "]\n";
	}
	
	public int getStocks() {
		// TODO Auto-generated method stub
		return stocks;
	}
	public int getPetId() {
		return petId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Category getType() {
		return type;
	}
	public void setType(Category type) {
		this.type = type;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
	public String getName() {
		return name;
	}
	
	
	 
}
