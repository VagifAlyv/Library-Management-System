import java.time.LocalDate;

import InterfacesEnums.Discount;

public class General extends LibraryMember{

	public General(LocalDate startBorrow, LocalDate endBorrow) {
		super(Discount.GENERAL, startBorrow, endBorrow);
	}

}
