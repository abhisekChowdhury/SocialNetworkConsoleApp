package com.Main;

import java.util.Arrays;

/**
 * @author Abhisek Chowdhury
 * 
 * This is the profile class (a child class of ArrayListWithListIterator), which is a blueprint for all the profile objects 
 * that are created in the SocialNetworkDemo class
 *
 */
public class Profile extends ArrayListWithListIterator<Object>{
	//Fields
	private String name;
	private String email;
	private String currentStatus;
	ListWithListIteratorInterface<String> listOfFriends = new ArrayListWithListIterator<>();
	
	/**
	 * The constructor for Profile class
	 * 
	 * @param name
	 * @param email
	 * @param currentStatus
	 * @param listOfFriends
	 */
	public Profile(String name, String email, String currentStatus, ListWithListIteratorInterface<String> listOfFriends) {
		this.name = name;
		this.email = email;
		this.currentStatus = currentStatus;
		this.listOfFriends = listOfFriends;
	}
	
	
	//Getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public ListWithListIteratorInterface<String> getListOfFriends() {
		return listOfFriends;
	}

	public void setListOfFriends(ListWithListIteratorInterface<String> listOfFriends) {
		this.listOfFriends = listOfFriends;
	}
	
	
	//This method is extremely important, otherwise Java will just print garbage values
    @Override
    public String toString() {
        return "\nName: " + this.name + 
        		", email: " + this.email + 
        		", status: "+this.currentStatus +
        		"\n" + "List of friends: " + Arrays.toString(listOfFriends.toArray())+"\n\n";
    }
	
}


