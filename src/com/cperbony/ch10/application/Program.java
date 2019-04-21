package com.cperbony.ch10.application;

import com.cperbony.ch10.application.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room Number");
        int number = sc.nextInt();

        System.out.println("check-in date (dd/MM/YYYY");
        Date checkIn = sdf.parse(sc.next());

        System.out.println("check-out date (dd/MM/YYYY");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in Reservation: Check-ou date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation :" + reservation.toString());

            System.out.println();
            System.out.println("Enter to update the reservation");

            System.out.println("Room Number");
            number = sc.nextInt();

            System.out.println("check-in date (dd/MM/YYYY)");
            checkIn = sdf.parse(sc.next());

            System.out.println("check-out date (dd/MM/YYYY)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            String error = reservation.updateDates(checkIn, checkOut);

            if (error != error) {
                System.out.println("Error in Reservation: " + error);
            } else {

                System.out.println("Reservation: " + reservation.toString());
            }
        }
        sc.close();
    }

}
