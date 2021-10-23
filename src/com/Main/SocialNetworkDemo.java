package com.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Abhisek Chowdhury
 * abhisekAssignment1-3475
 * 
 * This is the SocialNetworkDemo class, which implements the UI
 * and the operations of the Profile class and ArrayListWithListIterator class
 *
 */
public class SocialNetworkDemo{
	
	//Global Scanner class for user input
	static Scanner scanner = new Scanner(System.in);
	
	//List of Profile objects
	static ListWithListIteratorInterface<Profile> profileList = new ArrayListWithListIterator<>();
	
	public static void main(String[] args) {
		
		//loads sample database
		loadSampleDatabase();
		
		//launches the user interface
		userInterface();

	}
	
	/**
	 * This is a sample database which populates profileList with
	 * the first three Profile objects
	 */
	private static void loadSampleDatabase() {
				ListWithListIteratorInterface<String> friendSample1 = new ArrayListWithListIterator<>();
				ListWithListIteratorInterface<String> friendSample2 = new ArrayListWithListIterator<>();
				ListWithListIteratorInterface<String> friendSample3 = new ArrayListWithListIterator<>();
				friendSample1.add("friend1 1");
				friendSample1.add("friend1 2");
				friendSample1.add("friend1 3");
				friendSample1.add("friend1 4");
				friendSample1.add("friend1 5");

				friendSample2.add("friend2 1");
				friendSample2.add("friend2 2");
				friendSample2.add("friend2 3");
				friendSample2.add("friend2 4");
				friendSample2.add("friend2 5");
				
				friendSample3.add("friend3 1");
				friendSample3.add("friend3 2");
				friendSample3.add("friend3 3");
				friendSample3.add("friend3 4");
				friendSample3.add("friend3 5");
				
				profileList.add(new Profile("John","john@email.com","Available", friendSample1));
				profileList.add(new Profile("Adam","adam@hotmail.com","Offline", friendSample2));
				profileList.add(new Profile("Bag","Smith","Available", friendSample3));
	}

	/**
	 * This method consists of the user interface
	 */
	private static void userInterface() {
		int exit = 0;
		while(exit!=9) {
			System.out.println("\nWelcome to the SOCIAL NETWORK! \n\nWhat would you like to do today? Please select from the options below\n"
					+ "CAREFUL: THIS PROGRAM ACCEPTS EXACT VALUES!\n");
			System.out.println("1. Create a profile\n"
					+ "2. Modify a profile\n"
					+ "3. Search for User by name\n"
					+ "4. Add friends\n"
					+ "5. Show all User Names\n"
					+ "6. Remove a User\n"
					+ "7. Remove a friend\n"
					+ "8. Show all User details\n"
					+ "9. Exit the network");
			
			String selectedOption = scanner.nextLine();
			switch(Integer.parseInt(selectedOption)) {
			case 1:
				//To create a new profile
				createProfile();
				break;
			case 2:
				//To modify an existing profile
				modifyProfile();
				break;
			case 3:
				//To get an element by name
				getElementByName(profileList);
				break;
			case 4:
				//To add a new friend for a Profile
				addAFriend(profileList);
				break;
			case 5:
				//Displays names of Profiles
				System.out.println("Here is a list of all users: \n");
				showAllUsers();
				break;
			case 6:
				//Removes a profile
				removeProfile();
				break;
			case 7:
				//Removes a friend for a Profile
				removeFriend(profileList);
				break;
			case 8:
				//Displays all data in profileList
				showAllUserDetails();
				break;
			case 9:
				//Logs out of the Network
				exit = 9;
				System.out.print("Logged out\n\n");
				break;
			}
		}
	}
	

	/**
	 *Displays all the Profile objects in profileList
	 */
	private static void showAllUserDetails() {
		displayList(profileList);
		
	}

	/**
	 * Shows only the name of the users in profileList
	 */
	private static void showAllUsers() {
		for (Profile element : profileList) {
			System.out.println(element.getName() + "\n");
		}
		
	}

	/**
	 * Takes profileList parameter and removes a friend from the listOfFriends for a Profile object in profileList
	 * @param profileList2
	 */
	private static void removeFriend(ListWithListIteratorInterface<Profile> profileList2) {
		System.out.println("Enter the name of the user: \n");
		//int userPosition = Integer.parseInt(scanner.nextLine());
		String userName = scanner.nextLine();
		System.out.println("Enter the position of the friend to remove: (starting from 1)\n");
		int friendPosition = Integer.parseInt(scanner.nextLine());
		for (Profile user : profileList2) {
			if (user.getName().equals(userName)) {
				user.listOfFriends.remove(friendPosition);
			}
		}
	}

	/**
	 * Removes a user object from profileList
	 */
	private static void removeProfile() {
		System.out.println("Here is a list of all users: \nSelect a number to remove (starting from 1): \n");
		showAllUsers();
		int entry = Integer.parseInt(scanner.nextLine());
		profileList.remove(entry);
		
	}

	private static void addAFriend(ListWithListIteratorInterface<Profile> profileList2) {
		boolean check = false;
		System.out.println("Enter the name of the user: \n");
		String userName = scanner.nextLine();
		
		System.out.println("Enter name of friend to add: \n");
		String friendName = scanner.nextLine();
		for (Profile user : profileList2) {
			if (user.getName().equals(userName)) {
				System.out.println(userName + " was found!");
				check = true;
				user.listOfFriends.add(friendName);
			}
		}
		
		if (check==false) {
			System.out.println("Could not add friend since User does not exist!");
		}
	}

	/**
	 * Lets the user update a user profile object in profileList, by providing the position
	 */
	private static void modifyProfile() {
		System.out.println("Here is a list of all users: " + Arrays.toString(profileList.toArray()) + "\n");
		System.out.println("Enter the position of the User you want to modify (starting from 1)");
		int position = Integer.parseInt(scanner.nextLine());

		
		String name;
		String email;
		String status;
		ListWithListIteratorInterface<String> friendList = new ArrayListWithListIterator<>();
		String temp = "Y";
		String friendName;
		
		System.out.println("Enter name: ");
		name = scanner.nextLine();
		System.out.println("Enter email: ");
		email = scanner.nextLine();
		System.out.println("Enter status: ");
		status = scanner.nextLine();
		
		while(temp.equals("Y")) {
			System.out.println("Enter friend's name: ");
			friendName = scanner.nextLine();
			friendList.add(friendName);
			System.out.println("Friend added!");
			System.out.println("Continue to add more friends?\n"
					+ "Press 'Y' to add or anything else to exit.");
			temp = scanner.nextLine();
		}
		
		profileList.replace(position, new Profile(name,email,status,friendList));
		
	}

	/**
	 * Lets the user create a profile object to go inside profileList
	 */
	private static void createProfile() {
		String name;
		String email;
		String status;
		ListWithListIteratorInterface<String> friendList = new ArrayListWithListIterator<>();
		String temp = "Y";
		String friendName;
		
		System.out.println("Enter name: ");
		name = scanner.nextLine();
		System.out.println("Enter email: ");
		email = scanner.nextLine();
		System.out.println("Enter status: ");
		status = scanner.nextLine();
		
		while(temp.equals("Y")) {
			System.out.println("Enter friend's name: ");
			friendName = scanner.nextLine();
			friendList.add(friendName);
			System.out.println("Friend added!");
			System.out.println("Continue to add more friends?\n"
					+ "Press 'Y' to add or anything else to exit.");
			temp = scanner.nextLine();
		}
		
		profileList.add(new Profile(name,email,status,friendList));
		
	}

	/**
	 * Takes a list as a paramenter and displays its' contents
	 * @param aList
	 */
	public static void displayList(ListInterface<Profile> aList)
	{
      int numberOfEntries = aList.getLength();
      System.out.println();
      for (int position = 1; position <= numberOfEntries; ++position)
         System.out.print(aList.getEntry(position) + " ");
      System.out.println();
	}  // end displayList

	
	
	/**
	 * This method finds a user by their name
	 * @param name
	 * @param profileList
	 */
	public static void getElementByName(ListWithListIteratorInterface<Profile> profileList) {
		System.out.println("Enter the name of the person you are looking for: ");
		String personName = scanner.nextLine();
		int temp = 0;
		for (Profile person: profileList) {
			if (person.getName().equals(personName)) {
				System.out.println(person.getName()+" was found! Here are the details: \n"+person);
				temp++;
				break;
			}
		}
		if (temp<1) {
			System.out.println("User does not exist!");
		}
	}

}
