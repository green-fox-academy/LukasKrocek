package reservations;

public class Main {

    public static void main(String[] args) {
        Bookings bookings = new Bookings();
        int numberOfReservations = 10;
        for (int i = 0; i < numberOfReservations; i++) {
            bookings.addReservation(new Reservation());
        }

        for (Reservation reservation: bookings.reservations) {
            System.out.println(reservation);
        }

    }
}
