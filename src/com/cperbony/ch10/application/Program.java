package com.cperbony.ch10.application;

import com.cperbony.ch10.application.model.entities.Reservation;
import com.cperbony.ch10.application.model.entities.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room Number");
            int number = sc.nextInt();

            System.out.println("check-in date (dd/MM/YYYY");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("check-out date (dd/MM/YYYY");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation :" + reservation.toString());

            System.out.println();
            System.out.println("Enter to update the reservation");

            System.out.println("check-in date (dd/MM/YYYY)");
            checkIn = sdf.parse(sc.next());

            System.out.println("check-out date (dd/MM/YYYY)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation.toString());
        } catch (ParseException e) {
            System.out.println("Invalid Date Format Exception " + e.getMessage());
        } catch (DomainException e) {
            System.out.println("Error in reservation " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error " + e.getMessage());
        }
        sc.close();
    }

}
