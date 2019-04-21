package com.cperbony.ch10.application.model.entities;

import com.cperbony.ch10.application.model.entities.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roonNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in Reservation: Check-ou date must be after check-in date");
        }
        this.roomNumber = roonNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoonNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setRoonNumber(Integer roonNumber) {
        this.roomNumber = roonNumber;
    }

    public long duration() {
        //Pegar data em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates...");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in Reservation: Check-ou date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
