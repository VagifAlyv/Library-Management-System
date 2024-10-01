import java.time.LocalDate;
import InterfacesEnums.Discount;

public class StudentWithoutScholar extends LibraryMember{

	public StudentWithoutScholar(LocalDate startBorrow, LocalDate endBorrow) {
		super(Discount.STUDENTWITHOUTSCHOLAR, startBorrow, endBorrow);
	}

}
