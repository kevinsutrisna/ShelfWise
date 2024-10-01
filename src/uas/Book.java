package uas;

import java.util.ArrayList;

public class Book implements Borrowable {
    private ArrayList<String> authorList;
    private String title, isbn;
    private int availability;

    public Book(ArrayList<String> authorList, String title, String isbn, int availability) {
        this.authorList = authorList;
        this.title = title;
        this.isbn = isbn;
        this.availability = availability;
    }


    public void borrowItem() {
        if (availability > 0) {
            availability--;
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnItem() {
        availability++;
    }

    public String toString() {
        return "Book Title: " + title + "\nISBN: " + isbn + "\nAvailability: " + availability;
    }

	public ArrayList<String> getAuthorList() {
		return authorList;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAuthorList(ArrayList<String> authorList) {
		this.authorList = authorList;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
}
