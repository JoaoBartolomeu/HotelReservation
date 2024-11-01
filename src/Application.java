import Model.entities.Reservation;
import Model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation res;

        try {
            System.out.print("Room Number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());
            res = new Reservation(checkout, checkin, roomNumber);
            System.out.println(res);

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());
            res.updateDates(checkin, checkout);
            System.out.println(res);
        }catch (ParseException e){
            System.out.println("Invalid Date Format");
        }catch (DomainException e){
            System.out.println("Error in Reservation " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}