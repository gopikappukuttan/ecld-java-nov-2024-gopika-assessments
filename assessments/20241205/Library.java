package com.edstem.ecld.assessment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class LibraryItem {
    protected String id;
    protected String title;
    protected boolean available;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    abstract double calculateLateFee(int daysLate);


}

class Book extends LibraryItem {
    String author;
    String isbn;
    double lateFeePerDay = 2;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }
}

class Magazine extends LibraryItem {
    LocalDate issueDate;
    String publisher;
    double lateFeePerDay = 1;

    public Magazine(String id, String title, LocalDate issueDate, String publisher) {
        super(id, title);
        this.issueDate = issueDate;
        this.publisher = publisher;
    }

    @Override
    double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }
}

public class Library {

    List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(String id) {
        Iterator<LibraryItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            LibraryItem item = iterator.next();
            if (item.id.equals(id))
                iterator.remove();
        }
    }

    public LibraryItem searchByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.title.equalsIgnoreCase(title))
                return item;
        }
        return null;
    }

    public void borrowItem(String id) {
        for (LibraryItem item : items) {
            if (item.id.equals(id) && item.available)
                item.available = false;
            break;
        }
    }

    public void returnItem(String id) {
        for (LibraryItem item : items) {
            if (item.id.equals(id))
                item.available = true;
            break;
        }
    }

    public LibraryItem getOverdueItems(int daysOverdue) {
        List<LibraryItem> overdueItems = new ArrayList<>();
        for (LibraryItem item : items) {
            if (!item.available && item.calculateLateFee(daysOverdue) > 0) {
                overdueItems.add(item);
            }
        }
        return (LibraryItem) overdueItems;
    }


    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("1", "Java", "Gopika P A", "0134685991");
        Magazine magazine1 = new Magazine("2", "New Magazine", LocalDate.of(2024, 5, 15), "Publisher");
        library.addItem(book1);
        library.addItem(magazine1);
        //library.displayItems();
        //System.out.println(library.toString());
        // Search by title
        LibraryItem item = library.searchByTitle("Java");
        System.out.println("Found item: " + item.title);

        //using borrowItem method
        library.borrowItem("1");
        //using returnItem method
        library.returnItem("1");

        //using removeItem method
        library.removeItem("2");

       /* int daysOverdue = 5;
        for (LibraryItem overdueItem : library.getOverdueItems(daysOverdue)) {
            System.out.println("Overdue item: " + overdueItem.title
             +", Late Fee: " + overdueItem.calculateLateFee(daysOverdue));
        }*/
    }
}



