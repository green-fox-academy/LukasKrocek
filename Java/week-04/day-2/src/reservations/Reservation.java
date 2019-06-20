package reservations;

import interfaces.Reservationy;

import java.util.Scanner;

public class Reservation implements Reservationy {
    Scanner sc = new Scanner(System.in);
    String day;
    String code;

    Reservation() {
        day = getDowBooking();
        code = getCodeBooking();
    }

    @Override
    public String getDowBooking() {
        int day = (int) (Math.random() * 7 + 1);
        switch (day) {
            case 1:
                return "MON";
            case 2:
                return "TUE";
            case 3:
                return "WED";
            case 4:
                return "THU";
            case 5:
                return "FRI";
            case 6:
                return "SAT";
            case 7:
                return "SUN";
            default:
                return "Something is Wrong";
        }
    }

    @Override
    public String getCodeBooking() {
        String stringOfAllCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int lenghtOfCode = 8;
        String code = "";
        for (int i = 0; i < lenghtOfCode; i++) {
            code += stringOfAllCharacters.charAt((int) (Math.random() * stringOfAllCharacters.length() - 1));
        }
        return code;
    }

    @Override
    public String toString() {
        return "Booking# " + code + " for " + day;
    }
}

