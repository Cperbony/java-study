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
        CheckInsOut checkInsOut = new CheckInsOut(sc, sdf).invoke();

        try {
            System.out.println("Room Number");
            int number = sc.nextInt();

            Date checkIn = checkInsOut.getCheckIn();
            Date checkOut = checkInsOut.getCheckOut();

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation :" + reservation.toString());

            System.out.println();
            System.out.println("Enter to update the reservation");

            checkIn = checkInsOut.getCheckIn();
            checkOut = checkInsOut.getCheckOut();

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation.toString());
        } catch (DomainException e) {
            System.out.println("Error in reservation " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error " + e.getMessage());
        }
        sc.close();
    }

    private static class CheckinsDates {
        private Scanner sc;
        private SimpleDateFormat sdf;
        private Date checkIn;
        private Date checkOut;

        public CheckinsDates(Scanner sc, SimpleDateFormat sdf) {
            this.sc = sc;
            this.sdf = sdf;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }

        public CheckinsDates invoke() throws ParseException {
            System.out.println("check-in date (dd/MM/YYYY");
            checkIn = sdf.parse(sc.next());

            System.out.println("check-out date (dd/MM/YYYY");
            checkOut = sdf.parse(sc.next());
            return this;
        }
    }

    private static class CheckInsOut {
        private Scanner sc;
        private SimpleDateFormat sdf;
        private Date checkIn;
        private Date checkOut;

        public CheckInsOut(Scanner sc, SimpleDateFormat sdf) {
            this.sc = sc;
            this.sdf = sdf;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }

        public CheckInsOut invoke() throws ParseException {
            CheckinsDates checkinsDates = new CheckinsDates(sc, sdf).invoke();
            checkIn = checkinsDates.getCheckIn();
            checkOut = checkinsDates.getCheckOut();
            return this;
        }
    }
}
