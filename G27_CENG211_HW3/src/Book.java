import InterfacesEnums.BookPriority;

class Book extends BorrowedItem {

	private final double charge = 5;
	private final int dayLimit = 10;

	public Book(String itemNumber, String title, BookPriority bookPriority, String itemType, String authorGenre,
			String publisher, LibraryMember member) {
		super(itemNumber, title, bookPriority, itemType, authorGenre, publisher, member);
	}

	@Override
	public int calculateDaysExceeded() {
	    if (getMember() == null || getMember().getBorrowedDays() == 0) {
	        return 0;
	    } else {
	        return Math.max(getMember().getBorrowedDays() - dayLimit, 0);
	    }
	}

	@Override
	public double calculateLateCharge() {
		if (calculateDaysExceeded() > 0) {
			return 5;
		} else {
			return 0;
		}
	}

	// Borrowing Charge for Book=(Number of Days Borrowed)×(Borrowing Charge per Day for Book) ×(Priority)
	@Override
	public double calculateBorrowingCharge() {
		return getMember().getBorrowedDays() * charge * getBookPriority().getPriority();
	}

}