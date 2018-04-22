package pl.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.model.Cabin;
import pl.sda.model.Customer;
import pl.sda.model.Reservation;
import pl.sda.model.Ship;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        SessionFactory instance = HbnConfig.getInstance();

        Session session = instance.openSession();

        Transaction tx = session.beginTransaction();
        Random random = new Random();
        Ship ship = new Ship();
        ship.setCountOfMast(random.nextInt(10));
        ship.setLength(random.nextInt(3)*100);
        ship.setName("NaPohybel");
        ship.setPower(random.nextInt(12)*1000);
        ship.setVelocity(random.nextInt(5)*10);
        ship.setWeigth(random.nextInt(400)*1000);
        ship.setProductionYear(new Date());

        for (int i = 0; i < 100; i++) {
            Cabin cabin = new Cabin();
            cabin.setCapacity(random.nextInt(5));
            cabin.setLuxuryClass(random.nextInt(3));
            cabin.setNumber(i);
            cabin.setShip(ship);
            session.save(cabin);
        }
        session.save(ship);
        tx.commit();

        session.close();

        instance.close();
    }
}
