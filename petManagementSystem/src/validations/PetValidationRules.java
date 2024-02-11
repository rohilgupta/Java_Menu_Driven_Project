package validations;

import java.util.Map;
import java.util.Scanner;

import core.Order;
import core.Pet;
import petException.AuthorizationException;
import petException.OutOfStockException;
import util.PetCollection;

public interface PetValidationRules {

	static void logIn(Scanner sc) throws AuthorizationException
	{
		System.out.println("enter your userId and password :- ");
		if("admin".equals(sc.next()))
			if("admin".equals(sc.next()))
				return;
	throw new AuthorizationException("Only Admin can logIn !");
	}
	static void signIn(Scanner sc) throws AuthorizationException
	{
		System.out.println("enter your userId and password :- ");
		if("c1".equals(sc.next()))
			if("c1".equals(sc.next()))
				return;
	throw new AuthorizationException("Only Customer can logIn !");
	}
	static int checkStock(Pet p,int quantity) throws OutOfStockException 
	{			if(quantity<1)  throw new OutOfStockException("InValid quantity");
				if(p.getStocks()<quantity)
	throw new OutOfStockException("Out of Stock !");
				return quantity;
	}
	static int stockValidation(int quantity) throws OutOfStockException 
	{			if(quantity<1)  throw new OutOfStockException("InValid quantity");
				return quantity;
	}
	static Pet petValidation(Scanner sc,Map<Integer,PetCollection>petMap) throws AuthorizationException 
	{			System.out.println("enter pet id :- ");
	PetCollection p=petMap.get(sc.nextInt());
				if(p instanceof Pet)
					return (Pet)p;
	throw new AuthorizationException("Invalid pet id !");
	}
	static Order orderValidation(Scanner sc,Map<Integer,PetCollection>petMap) throws AuthorizationException 
	{			System.out.println("enter order id :- ");
	PetCollection p=petMap.get(sc.nextInt());
				if(p instanceof Order)
					return (Order)p;
	throw new AuthorizationException("Invalid order id !");
	}
	static String duplicatePet(String pet,Map<Integer,PetCollection>petMap) throws AuthorizationException
	{
		for(PetCollection p:petMap.values())
		{
			if(p instanceof Pet)
				{if(((Pet)p).getName().equals(pet))
					throw new AuthorizationException("can't register same name pet again !");
				}
		}
		return pet;
	}
}
