package tester;

import java.time.LocalDate;

import enums.PenColor;
import enums.PenEnum;

public class Pen implements Comparable<Pen> {
	private static Object newPen;
	private int id;
	private PenEnum brand;
	private PenColor color;
	private LocalDate date;
	private double price;

	public Pen(int id, PenEnum brand, PenColor color, LocalDate date, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.date = date;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[PenId -> " + id + " Brand -> " + brand + " Color -> " + color + " Date -> " + date + " Price ->"
				+ price + " ]";
	}

	public Pen(int id) {
		super();
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public int compareTo(Pen newPens) {
		Integer Id = this.id;
//	Integer Id2 =  newPens.id;
		return Id.compareTo((Integer) newPens.id);
	}

	public void setDiscountPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pen) {
			Pen temp = (Pen) obj;

			return this.id == temp.id;
		}
		return false;
	}

	public PenEnum getBrand() {
		return brand;
	}

	public void setBrand(PenEnum brand) {
		this.brand = brand;
	}

	public PenColor getColor() {
		return color;
	}

	public void setColor(PenColor color) {
		this.color = color;
	}
}
