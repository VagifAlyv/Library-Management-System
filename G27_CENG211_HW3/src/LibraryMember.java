
import java.time.LocalDate;
import InterfacesEnums.Discount;

class LibraryMember {

    private Discount discount;
    private LocalDate startBorrow;
    private LocalDate endBorrow;

    public LibraryMember(Discount discount, LocalDate startBorrow, LocalDate endBorrow) {
        this.discount = discount;
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
    }

    public int getBorrowedDays() {
        if (startBorrow != null && endBorrow != null) {
            return (int) startBorrow.until(endBorrow).getDays();
        } else {
            return 0;
        }
    }

    public double getDiscountOfMember() {
        if (discount != null) {
            return discount.getDiscount();
        } else {
            return 0;
        }
    }
}
