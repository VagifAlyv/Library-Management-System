import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import InterfacesEnums.BookPriority;

import java.util.ArrayList;

public class FileIO {
	private final String file = "items.csv";

	public void readFromFile(ArrayList<BorrowedItem> borrowedItemList, ArrayList<LibraryMember> memberList) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");

				String itemNumber = values[0];
				String title = values[1];
				BookPriority priority = getPriority(values[2]);
				String itemType = values[3];
				String authorGenre = values[4];
				String publisher = values[5];
				LocalDate startDate = LocalDate.parse(parseDate(values[7]));
				LocalDate endDate = LocalDate.parse(parseDate(values[8]));
				// Creating a member
				LibraryMember member = newMember(values[6], startDate, endDate);
				memberList.add(member);

				// creating new book
				if (itemType.equalsIgnoreCase("book")) {
					Book book = new Book(itemNumber, title, priority, itemType, authorGenre, publisher, member);
					borrowedItemList.add(book);
				}
				// Creating new magazine
				else if (itemType.equalsIgnoreCase("magazine")) {
					Magazine magazine = new Magazine(itemNumber, title, priority, itemType, authorGenre, publisher, member);
					borrowedItemList.add(magazine);
				}

			}
		} catch (IOException e) {
			System.out.println("File could not be read!");
		}
	}

	// getting the priority for library item
	private BookPriority getPriority(String string) {
		switch (string.toLowerCase()) {
		case "invaluable":
			return BookPriority.INVALUABLE;

		case "highly significant":
			return BookPriority.HIGHLYSIGNIFICANT;

		case "noteworthy":
			return BookPriority.NOTEWORTHY;
		default:
			throw new IllegalArgumentException("Invalid book priority!");
		}
	}

	// changes the format of date
	private String parseDate(String dateString) {
		String date[] = dateString.split("/");
		return date[2] + "-" + date[1] + "-" + date[0];

	}

	// getting the discount for member
	private LibraryMember newMember(String memberType, LocalDate startDate, LocalDate endDate) {
		LibraryMember librarymember;

		switch (memberType.toLowerCase()) {
		case "general":
			librarymember = new General(startDate, endDate);
			break;
		case "studentwscholar":
			librarymember = new StudentWithScholar(startDate, endDate);
			break;
		case "studentwoscholar":
			librarymember = new StudentWithoutScholar(startDate, endDate);
			break;
		default:
			throw new IllegalArgumentException("Invalid member type: " + memberType);
		}

		return librarymember;
	}

}
