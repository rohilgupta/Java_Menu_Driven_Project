package tester;

import java.time.LocalDate;

public class Publication {
    private String type;
	private int id;
	private String title;
	private double price;
	LocalDate date;
	private int Rate;
	public Publication(String type,int id, String title, double price, LocalDate date, int rate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.date = date;
		Rate = rate;
		this.type = type;
	}
	public Publication(int id)
	{
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	@Override
	public String toString() {
		return type+" =>" + " [PublicationId = " + id + ", Title= " + title + ", Price= " + price + ", PublishDate= " + date + ", Rating(outOf 10) = " + Rate
				+ "]";
	}
}
