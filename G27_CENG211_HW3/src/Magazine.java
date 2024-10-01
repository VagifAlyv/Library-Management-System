import InterfacesEnums.BookPriority;

class Magazine extends BorrowedItem {

	private final int charge = 7;
	private final int dayLimit = 2;

	public Magazine(String itemNumber, String title, BookPriority bookPriority, String itemType, String authorGenre,
			String publisher, LibraryMember member) {
		super(itemNumber, title, bookPriority, itemType, authorGenre, publisher, member);

	}

	@Override
	public int calculateDaysExceeded() {
		return getMember().getBorrowedDays() - dayLimit;
	}

	@Override
	public double calculateLateCharge() {
		if (calculateDaysExceeded() > 0) {
			return 2;
		}
		else {
			return 0;
		}
	}

	// Borrowing Charge for Magazine=(Number of Days Borrowed) × (Borrowing Charge per Day for Magazine) × (Priority)
	@Override
	public double calculateBorrowingCharge() {
		return getMember().getBorrowedDays() * charge * getBookPriority().getPriority();
	}

}
