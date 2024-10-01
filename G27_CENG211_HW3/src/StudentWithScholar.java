import java.time.LocalDate;
import InterfacesEnums.Discount;

public class StudentWithScholar extends LibraryMember {

	public StudentWithScholar(LocalDate startBorrow, LocalDate endBorrow) {
		super(Discount.STUDENTWITHSCHOLAR, startBorrow, endBorrow);
	}

}
