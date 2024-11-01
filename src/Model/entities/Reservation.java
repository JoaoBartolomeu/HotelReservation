package Model.entities;

import Model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkinDate;
    private Date checkoutDate;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){}
    public Reservation(Date checkoutDate, Date checkinDate, Integer roomNumber) throws DomainException {
        if (checkoutDate.before(checkinDate)){
            throw new DomainException("A data de check-out não pode ser anterior à data de check-in.");
        }
        this.checkoutDate = checkoutDate;
        this.checkinDate = checkinDate;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Integer duration(){
        long diffInMillies = checkoutDate.getTime() - checkinDate.getTime();
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkinDate, Date checkoutDate) throws DomainException {

        if (checkinDate == null || checkoutDate == null){
            throw new DomainException("As datas de check-in e check-out não podem ser nulas.");
        }
        if (checkoutDate.before(checkinDate)){
            throw new DomainException("A data de check-out não pode ser anterior à data de check-in.");
        }
        this.checkoutDate = checkoutDate;
        this.checkinDate = checkinDate;
    }

    @Override
    public String toString() {
        return "Reservation: " +
                "Room " + roomNumber +
                ", check-in: " + sdf.format(checkinDate) +
                ", check-out: " + sdf.format(checkoutDate) + " "
                + duration()  + " nights";
    }
}

