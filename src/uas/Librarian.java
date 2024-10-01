package uas;

import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends User{
	private ArrayList<MeetingRoom> roomList = new ArrayList<>();
	public Librarian(String userId, String name, String phoneNumber) {
		super(userId, name, phoneNumber);
	}
	public void ShowMenu(Scanner scan, LibarySystem system)
	{
		do
		{
			System.out.println("Menu Librarian");
			System.out.println("------------------------------");
			System.out.println("1. Add a Book");
			System.out.println("2. Add a Librarian");
			System.out.println("3. Add a Member");
			System.out.println("4. Process borrowing a Meeting Room key");
			System.out.println("5. Process returning a Meeting Room key");
			System.out.println("6. Show Transaction");
			System.out.println("7. Exit");
			System.out.print("Choice: ");
			Integer choice = 0;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Masukan angka 1-7");
			}
			if(choice == 1)
			{
				addBook(scan, system);
			}
			else if(choice == 2)
			{
				addLibrarian(scan, system);
			}
			else if(choice == 3)
			{
				addMember(scan, system);
			}
			else if(choice == 4)
			{
				
				borrowingMeetingRoom(scan, system);
			}
			else if(choice == 5)
			{
				returningMeetingRoom(scan, system);
			}
			else if(choice == 6)
			{
				system.showTransaction();
			}
			else if(choice == 7)
			{
				break;
			}
			}while(true);
	}
	public void borrowingMeetingRoom(Scanner scan, LibarySystem system) {
		system.showAvailabeMeetingRoom();
		do
		{
			System.out.printf("Choose room: ");
			String room =  scan.nextLine();
			int Booked = 0;
			for (Borrowable borrowable : system.getItems()) {
				if(borrowable instanceof MeetingRoom)
				{
					MeetingRoom MeetingRoom = (MeetingRoom)borrowable;
					if(MeetingRoom.getRoomName().compareTo(room) == 0)
					{
						MeetingRoom.borrowItem();
						Booked = 1;
						roomList.add(MeetingRoom);
						Transaction transaction = new Transaction("borrow");
						transaction.generateId();
						system.getTransactions().add(transaction);
						break;
					}
				}
			}
			if (Booked == 1)
			{
				break;
			}
		}while(true);
	}
	public void returningMeetingRoom(Scanner scan, LibarySystem system) {
		if(roomList.isEmpty())
		{
			System.out.println("No borrowed book");
		}
		else
		{
			showBorrowedRoom();
			do
			{
				System.out.printf("Choose room: ");
				String room =  scan.nextLine();
				int Booked = 0;
				for (Borrowable borrowable : system.getItems()) {
					if(borrowable instanceof MeetingRoom)
					{
						MeetingRoom MeetingRoom = (MeetingRoom)borrowable;
						if(MeetingRoom.getRoomName().compareTo(room) == 0)
						{
							MeetingRoom.returnItem();
							Booked = 1;
							roomList.remove(MeetingRoom);
							Transaction transaction = new Transaction("return");
							transaction.generateId();
							system.getTransactions().add(transaction);
							break;
						}
					}
				}
				if (Booked == 1)
				{
					break;
				}
			}while(true);
		}
		
	}
	public void addLibrarian(Scanner scan, LibarySystem system) {
		String userId, name, phoneNumber;
		System.out.println("User id: ");
		userId = scan.nextLine();
		System.out.println("Name: ");
		name = scan.nextLine();
		System.out.println("Phone number: ");
		phoneNumber = scan.nextLine();
		Librarian librarian = new Librarian(userId, name, phoneNumber);
	    system.getUsers().add(librarian);
	    Transaction transaction = new Transaction("add");
		transaction.generateId();
		system.getTransactions().add(transaction);
	    
	}
	
	public void addMember(Scanner scan, LibarySystem system) {
		String userId, name, phoneNumber;
		System.out.println("User id: ");
		userId = scan.nextLine();
		System.out.println("Name: ");
		name = scan.nextLine();
		System.out.println("Phone number: ");
		phoneNumber = scan.nextLine();
		Member member = new Member(userId, name, phoneNumber);
	    system.getUsers().add(member);
	    Transaction transaction = new Transaction("add");
		transaction.generateId();
		system.getTransactions().add(transaction);
	    
	}
	
	public void addBook(Scanner scan, LibarySystem system) {
		ArrayList<String> authorList = new ArrayList<>();
		String title, isbn;
		System.out.println("Judul: ");
		title = scan.nextLine();
		System.out.println("ISBN: ");
		isbn = scan.nextLine();
		Integer availability = 0;
		do
		{
			System.out.println("availability: ");
			try {
				availability = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Masukan angka lebih dari 0");
			}
			if (availability >= 1)
			{
				break;
			}
		}while(true);
		String author;
		do
		{
			System.out.println("Author (Type exit to leave loop):");
			author = scan.nextLine();
			if(author.compareTo("exit") == 0)
			{
				break;
			}
			else
			{
				authorList.add(author);
			}
		}while(true);
		Book book = new Book(authorList, title, isbn, availability);
	    system.getItems().add(book);
	    Transaction transaction = new Transaction("add");
		transaction.generateId();
		system.getTransactions().add(transaction);
	}
	public void showBorrowedRoom() {
		for (MeetingRoom room : roomList) {
			System.out.printf("Borrowed room\nRoom name: %s\nAvailability: %b\nCapacity: %d\n", room.getRoomName(), room.isAvailability(), room.getCapacity());
		}
	}
}
