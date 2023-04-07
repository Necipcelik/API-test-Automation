package pojos;

public class PojoHerokuappResponce {

    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerokuappResponce(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerokuappResponce() {
    }

    @Override
    public String toString() {
        return "PojoHerokuappResponce{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
