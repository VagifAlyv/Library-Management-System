import java.util.ArrayList;

public class Query {

	private ArrayList<BorrowedItem> anyItemArrayList;
	private ArrayList<LibraryMember> memberArrayList;

	public Query() {
		anyItemArrayList = new ArrayList<>();
		memberArrayList = new ArrayList<>();
	
		FileIO file = new FileIO();
		file.readFromFile(anyItemArrayList, memberArrayList);
	}

	public void printAllBooks() {
		for (BorrowedItem book : anyItemArrayList) {
			print(book);
			System.out.println();
		}
	}

	public BorrowedItem searchBook(String title) {
		for (BorrowedItem tempBook : anyItemArrayList) {
			if (tempBook.searchByTitle(title)) {
				return tempBook;
			}
		}
		return null;
	}

	public BorrowedItem searchBook(String title, String itemType) {
		for (BorrowedItem tempBook : anyItemArrayList) {
			if (tempBook.searchByTitleAndType(title, itemType)) {
				return tempBook;
			}
		}
		return null;
	}

	public void queries() {
		printAllBooks();

		BorrowedItem historyOfArt = searchBook("history of art", "book");
		BorrowedItem animalFarm = searchBook("Animal Farm");

		System.out.println();

		printResult("History of Art", historyOfArt);
		printResult("Animal Farm", animalFarm);
	}

	private void printResult(String title, BorrowedItem book) {
		if (book != null) {
			System.out.println(title + " exists." );
			print(book);
		} else {
			System.out.println();
			System.out.println("The book " + title + " does not exist.");
		}
	}

	public void print(BorrowedItem book) {
		
		int dayExceed = book.calculateDaysExceeded();
		String exceed = (dayExceed > 0) ? " Exceeds " : " Not Exceeds ";

		System.out.printf("Item Number: " + book.getItemNumber() + " Title: " + book.getTitle() + " Item Type: "
				+ book.getItemType() + " Borrowing Days: " + book.getMember().getBorrowedDays() + " days " + "Exceed: " + exceed
				+ " Total Price: $" + book.calculateTotalPrice());
	}

}
