package uas;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu
{
	Scanner scan;
	LibarySystem system;
	public MainMenu(Scanner scan, LibarySystem system) {
		this.scan = scan;
		this.system = system;
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		LibarySystem system = new LibarySystem();
		MainMenu main = new MainMenu(scan, system);
		Initiziale(system);
		while(true)
		{
			int count = main.ShowMenu(scan, system);
			if (count == 1)
			{
				break;
			}
		}
	}
	
	public int ShowMenu(Scanner scan, LibarySystem system)
	{
		do
		{
			System.out.println("Selamat datang ke ShelfWise");
			System.out.println("Masukan user ID valid U001 untuk member, U002 untuk librarian dan exit untuk keluar loop");
			System.out.println("Input user ID : ");
			String choice = scan.nextLine();
			for (User  user: system.getUsers()) {
				if(user instanceof Member)
				{
					Member member = (Member)user;
					if(user.getUserId().compareTo(choice) == 0)
					{
						member.ShowMenu(scan, system);
						return 0;
					}
				}
				if(user instanceof Librarian)
				{
					Librarian librarian = (Librarian)user;
					if(librarian.getUserId().compareTo(choice) == 0)
					{
						librarian.ShowMenu(scan, system);
						return 0;
					}
				}
			}
			if(choice.compareTo("exit") == 0)
			{
				return 1;
			}
		}while(true);
	}
	public static void Initiziale(LibarySystem system)
	{
	    ArrayList<String> author_list = new ArrayList<String>();
	    author_list.add("Gerrick");
	    author_list.add("Rick");
	    Book book = new Book(author_list, "Bintang", "984-35532-42241", 2);
	    system.getItems().add(book);

	    ArrayList<String> author_list2 = new ArrayList<String>();
	    author_list2.add("Bambang");
	    author_list2.add("Riko");
	    Book book2 = new Book(author_list2, "Bulan", "982-24432-63841", 1);
	    system.getItems().add(book2);

	    MeetingRoom room = new MeetingRoom(5, "Ruang 1");
	    system.getItems().add(room);

	    MeetingRoom room2 = new MeetingRoom(10, "Ruang 2");
	    system.getItems().add(room2);

	    Member member = new Member("U001", "Kevin", "094209201");
	    system.getUsers().add(member);

	    Librarian librarian = new Librarian("U002", "John", "244253925");
	    system.getUsers().add(librarian);
	}

}
