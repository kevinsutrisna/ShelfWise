package uas;


import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User{
	private ArrayList<Book> bookList = new ArrayList<>();
	public Member(String userId, String name, String phoneNumber) {
		super(userId, name, phoneNumber);
	}
	
	public void ShowMenu(Scanner scan, LibarySystem system)
	{
		
		do
		{
			System.out.println("Menu Member (Self-Service)");
			System.out.println("------------------------------");
			System.out.println("1. Show my borrowed item(s)");
			System.out.println("2. Borrow a Book");
			System.out.println("3. Return a Book");
			System.out.println("4. Exit");
			System.out.print("Choice: ");
			Integer choice = 0;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Masukan angka 1-4");
			}
			if(choice == 1)
			{
				if(bookList.isEmpty())
				{
					System.out.println("No borrowed book");
				}
				else
				{
					showBorrowedBook();
				}
			}
			else if(choice == 2)
			{
				borrowBook(scan, system);
			}
			else if(choice == 3)
			{
				returnBook(scan, system);
			}
			else if(choice == 4)
			{
				break;
			}
			}while(true);
		
	}

	public void returnBook(Scanner scan, LibarySystem system) {
		if(bookList.isEmpty())
		{
			System.out.println("No borrowed book");
		}
		else
		{
			showBorrowedBook();
			do
			{
				System.out.printf("Choose title: ");
				String title =  scan.nextLine();
				int booked = 0;
				for (Borrowable borrowable : system.getItems()) {
					if(borrowable instanceof Book)
					{
						Book book = (Book)borrowable;
						if(book.getTitle().compareTo(title) == 0)
						{
							book.returnItem();
							booked = 1;
							bookList.remove(book);
							Transaction transaction = new Transaction("return");
							transaction.generateId();
							system.getTransactions().add(transaction);
							break;
						}
					}
				}
				if (booked == 1)
				{
					break;
				}
			}while(true);
		}
		
	}

	public void showBorrowedBook() {
		for (Book book : bookList) {
			System.out.printf("Borrowed book\nTitle: %s\nISBN: %s\nAvailability: %d\nAuthors: ", book.getTitle(), book.getIsbn(), book.getAvailability());
			for (String authors : book.getAuthorList()) {
				System.out.printf("%s ", authors);
			}
			System.out.println("");
		}
	}
	
	public void borrowBook(Scanner scan, LibarySystem system)
	{
		system.showAvailabeBook();
		do
		{
			System.out.printf("Choose title: ");
			String title =  scan.nextLine();
			int booked = 0;
			for (Borrowable borrowable : system.getItems()) {
				if(borrowable instanceof Book)
				{
					Book book = (Book)borrowable;
					if(book.getTitle().compareTo(title) == 0)
					{
						book.borrowItem();
						booked = 1;
						bookList.add(book);
						Transaction transaction = new Transaction("borrow");
						transaction.generateId();
						system.getTransactions().add(transaction);
						break;
					}
				}
			}
			if (booked == 1)
			{
				break;
			}
		}while(true);
	}
}
