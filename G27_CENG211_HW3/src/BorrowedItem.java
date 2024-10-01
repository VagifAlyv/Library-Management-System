import InterfacesEnums.BookPriority;
import InterfacesEnums.Borrowing;
import InterfacesEnums.Searchable;

abstract class BorrowedItem implements Borrowing<LibraryMember>, Searchable {
	private String itemNumber;
	private String title;
	private BookPriority bookPriority;
	private String itemType;
	private String authorGenre;
	private String publisher;
	private LibraryMember member;

	public BorrowedItem(String itemNumber, String title, BookPriority bookPriority, String itemType, String authorGenre,
			String publisher, LibraryMember member) {
		this.itemNumber = itemNumber;
		this.title = title;
		this.bookPriority = bookPriority;
		this.itemType = itemType;
		this.member = member;
		this.authorGenre = authorGenre;
		this.publisher = publisher;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public String getTitle() {
		return title;
	}

	public BookPriority getBookPriority() {
		return bookPriority;
	}

	public String getItemType() {
		return itemType;
	}

	public LibraryMember getMember() {
		return member;
	}

	public String getAuthor() {
		return authorGenre;
	}

	public String getPublisher() {
		return publisher;
	}

	// Searching for books
	public boolean searchByTitle(String searchTitle) {
		return title.equalsIgnoreCase(searchTitle);
	}

	public boolean searchByTitleAndType(String searchTitle, String searchType) {
		return searchByTitle(searchTitle) && itemType.equalsIgnoreCase(searchType);
	}

	// Borrowing item
	public boolean borrowItem(LibraryMember borrower) {
		if (this.member == null) {
			this.member = borrower;
			// Item borrowed
			return true;
		} else {
			// Item has already been borrowed
			return false;
		}
	}

	// Abstract methods for specific implementations
	public abstract double calculateLateCharge();

	public abstract int calculateDaysExceeded();

	public abstract double calculateBorrowingCharge();

	// Getting the discount
	public double calculateDiscount() {
		return calculateBorrowingCharge() * member.getDiscountOfMember();
	}

	// Calculating total price
	public double calculateTotalPrice() {
		return (calculateBorrowingCharge() - calculateDiscount()) + calculateLateCharge();
	}
}
