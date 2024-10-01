package uas;

import java.util.ArrayList;

public class LibarySystem {
	private ArrayList<Borrowable> items = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Transaction> transactions = new ArrayList<>();
	public LibarySystem(ArrayList<Borrowable> items, ArrayList<User> users, ArrayList<Transaction> transactions) 
	{
		this.items = items;
		this.users = users;
		this.transactions = transactions;
	}
	public LibarySystem() 
	{
		
	}
	public ArrayList<Borrowable> getItems() {
		return items;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setItems(ArrayList<Borrowable> items) {
		this.items = items;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void showAvailabeBook()
	{
		System.out.println("Book: ");
		for (Borrowable borrowable : items) {
			if(borrowable instanceof Book)
			{
				Book book = (Book)borrowable;
				if(book.getAvailability() >= 1)
				{
					System.out.printf("Title: %s\nISBN: %s\nAvailability: %d\nAuthors: ", book.getTitle(), book.getIsbn(), book.getAvailability());
					for (String authors : book.getAuthorList()) {
						System.out.printf("%s ", authors);
					}
					System.out.println("");
				}
			}
		}
	}
	public void showAvailabeMeetingRoom()
	{
		System.out.println("Meeting room: ");
		for (Borrowable borrowable : items) {
			if(borrowable instanceof MeetingRoom)
			{
				MeetingRoom MeetingRoom = (MeetingRoom)borrowable;
				if(MeetingRoom.isAvailability() == true)
				{
					System.out.printf("Room name: %s\nAvailability: %b\nCapacity: %d\n", MeetingRoom.getRoomName(), MeetingRoom.isAvailability(), MeetingRoom.getCapacity());
				}
			}
		}
	}
	
	public void showTransaction()
	{
		System.out.println("Transactions:");
		for (Transaction transaction : transactions) {
			transaction.display();
		}
	}
}
