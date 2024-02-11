package tester;

import static util.PetServices.*;
import static util.PetServices.ExportDataAsBinary;
import static util.PetServices.addNewPet;
import static util.PetServices.checkOrderStatus;
import static util.PetServices.displayAllPet;
import static util.PetServices.orderPet;
import static util.PetServices.updateOrderStatus;
import static util.PetServices.updatePetDetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import petException.AuthorizationException;
import util.PetCollection;
import util.PetServices;

public class PetStore implements PetServices {

	public static void main(String[] args) throws ClassNotFoundException, AuthorizationException, IOException {
		// Initialization Phase start
		boolean flag = false;
		Map<Integer, PetCollection> petMap = new HashMap<>();
		try (Scanner sc = new Scanner(System.in)) { 
			System.out.println("Reading data from binary file :-");
			
			petMap=PetServices.importData(sc);
		
			while (!flag) {
				System.out.println("1)Add new Pet \n" + "2)Update Pet details \n" + "3)Display all available pets\n"
						+ "4)Order a Pet\n" + "5)Check order status by Order Id\n" + "6)Update order status \n"
						+ "7)print all details \n" + "8)save data in binary file\n" + "9)display all details of Orders\n"+"10.exit\n");
				try { 
					switch (sc.nextInt()) {
					case 1:
						addNewPet(sc, petMap);
						break;
					case 2:
						updatePetDetails(sc, petMap);
						break;
					case 3:
						displayAllPet(petMap);
						break;
					case 4:
						orderPet(sc, petMap);
						break;
					case 5:
						checkOrderStatus(sc, petMap);
						break;
					case 6:
						updateOrderStatus(sc, petMap);
						break;
					case 7:
						ExportData(sc, petMap);
						break;
					case 8:
						ExportDataAsBinary(sc, petMap);
						break;
					case 9:
						displayAllOrder(sc,petMap);
						break;
					case 10:
						flag = true;
						System.out.println("Bye !");
						break;
					default:
						System.out.println("Invalid choice !");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
