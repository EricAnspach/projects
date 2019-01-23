package business;

import java.time.LocalDate;

public class Reservation {

    private LocalDate arrivalDate;
    private LocalDate departureDate;

    final private double NIGHTLYRATE = 145.00;

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }


    public String getArrivalDateFormatted() {
        return arrivalDateFormatted;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String  getDepartureDateFormatted() {
        return departureDateFormatted;
    }
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfNights() {

    }

    public String getPricePerNightFormatted() {

    }

    public double getTotalPrice() {

    }

    public String getTotalPriceFormatted() {

    }
}
