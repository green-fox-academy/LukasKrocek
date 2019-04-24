package reservations;

import interfaces.Reservationy;

import java.util.ArrayList;
import java.util.List;

public class Bookings {
    List <Reservation> reservations;

    Bookings (){
        reservations = new ArrayList<>();
    }
    public void addReservation (Reservation reservation){
        reservations.add(reservation);
    }
}
