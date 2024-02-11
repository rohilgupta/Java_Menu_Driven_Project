package util;

import static validations.PetValidationRules.checkStock;
import static validations.PetValidationRules.duplicatePet;
import static validations.PetValidationRules.logIn;
import static validations.PetValidationRules.petValidation;
import static validations.PetValidationRules.stockValidation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import core.Category;
import core.Order;
import core.Pet;
import core.Status;
import petException.AuthorizationException;
import petException.OutOfStockException;
import validations.PetValidationRules;

public interface PetServices extends PetValidationRules {

	static void addNewPet(Scanner sc, Map<Integer, PetCollection> petMap)
			throws AuthorizationException, OutOfStockException {
		logIn(sc);
		System.out.println("Avaliable pet catagory : ");
		for (Category c : Category.values())
			System.out.print(c.name() + "\t");
		System.out.println("enter pet details as :- name, category, unitPrice and stocks");
		Pet p = new Pet(duplicatePet(sc.next(), petMap), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(),
				stockValidation(sc.nextInt()));
		petMap.put(p.getPetId(), p);
		System.out.println("successfully register !");
	}

	static void updatePetDetails(Scanner sc, Map<Integer, PetCollection> petMap)
			throws AuthorizationException, OutOfStockException {
		logIn(sc);
		Pet temp = petValidation(sc, petMap);
		System.out.println("enter pet details as :- name, category, unitPrice and stocks");
		temp.setName(sc.next());
		temp.setType(Category.valueOf(sc.next().toUpperCase()));
		temp.setUnitPrice(sc.nextDouble());
		temp.setStocks(stockValidation(sc.nextInt()));

		System.out.println("successfully updated !");
	}

	static void displayAllPet(Map<Integer, PetCollection> petMap) {
		petMap.values().stream().filter(i -> (i instanceof Pet)).forEach(System.out::println);
	}

	static void orderPet(Scanner sc, Map<Integer, PetCollection> petMap)
			throws AuthorizationException, OutOfStockException {
		Pet p = petValidation(sc, petMap);
		System.out.println("enter quantity of pet :- ");
		int quantity = checkStock(p, sc.nextInt());
		Order o = new Order(p.getPetId(), quantity);
		p.setStocks(p.getStocks() - quantity);
		System.out.println("successfully order place !");
		petMap.put(o.getOrderId(), o);
		System.out.println(o);

	}

	static void checkOrderStatus(Scanner sc, Map<Integer, PetCollection> petMap) throws AuthorizationException {
		Order o = PetValidationRules.orderValidation(sc, petMap);
		System.out.println(o);
	}

	static void updateOrderStatus(Scanner sc, Map<Integer, PetCollection> petMap) throws AuthorizationException {
		logIn(sc);
		Order o = PetValidationRules.orderValidation(sc, petMap);
		System.out.println("Status catagory as : ");
		for (Status s : Status.values())
			System.out.println(s.name());
		System.out.println("enter updated status :- ");
		o.setStatus(Status.valueOf(sc.next().toUpperCase()));
		System.out.println("status updated !");
	}

	static void ExportData(Scanner sc, Map<Integer, PetCollection> petMap) throws AuthorizationException, IOException {
		logIn(sc);
		//System.out.println("enter txt file name :- \n");
		//sc.nextLine();
		try (PrintWriter pw = new PrintWriter(new FileWriter("petData.txt"))) {
			petMap.values().stream().forEach(pw::println);
			System.out.println("done !");
		}
	}

	static void ExportDataAsBinary(Scanner sc, Map<Integer, PetCollection> petMap)
			throws AuthorizationException, IOException {
		logIn(sc);
		// System.out.println("enter .ser file name :- ");
		sc.nextLine();
		ObjectOutputStream pw = new ObjectOutputStream(new FileOutputStream("petData.ser"));
		// Consumer<PetCollection>ref=i->{try{pw.writeObject(i);}catch(Exception e)
		// {e.printStackTrace();}};

		pw.writeObject(petMap);
		System.out.println("done !");
	}

	@SuppressWarnings("unchecked")
	static Map<Integer, PetCollection> importData(Scanner sc)
			throws AuthorizationException, IOException, ClassNotFoundException {
		// logIn(sc);
		// System.out.println("enter .ser file name :- ");
		// sc.nextLine();
		try (ObjectInputStream pw = new ObjectInputStream(new FileInputStream("petData.ser"))) {
			return (Map<Integer, PetCollection>) pw.readObject();
		}
		
	}
	static void displayAllOrder(Scanner sc,Map<Integer,PetCollection> petMap) throws AuthorizationException 
	{	logIn(sc);
		petMap.values().stream().filter(i -> (i instanceof Order)).forEach(System.out::println);
	}
}
