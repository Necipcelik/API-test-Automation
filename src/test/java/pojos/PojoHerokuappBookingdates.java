package pojos;

public class PojoHerokuappBookingdates {
/*
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
}
 */
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public PojoHerokuappBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public PojoHerokuappBookingdates() {
    }

    @Override
    public String toString() {
        return "pojoHerokuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
