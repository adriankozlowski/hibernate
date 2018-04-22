package pl.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.sda.model.Cabin;
import pl.sda.model.Customer;
import pl.sda.model.Reservation;
import pl.sda.model.Ship;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        SessionFactory instance = HbnConfig.getInstance();

        Session session = instance.openSession();

        //Najkrótsze zapytanie HQL
        hqlQuery(session);
        //zapytanie HQL
        hqlWithWhereClause(session);
        //2. sposób na wyciągnięcie danych z bazy
        getShipDirectlyFromSession(session);

        //wykomentowane, zeby nie tworzyły się nowe statki
        //createShipWithCabins(session);

        session.close();

        instance.close();
    }

    private static void getShipDirectlyFromSession(Session session) {
        Ship ship = session.find(Ship.class, 4L);
    }

    private static void hqlWithWhereClause(Session session) {
        Query query = session.createQuery("select count(s) from Ship s where  s.length > 100");
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
    }

    private static void hqlQuery(Session session) {
        Query query = session.createQuery("from Ship s");
        List<Ship> list = query.list();
        for (Ship ship : list) {
            System.out.println( ship.getId()+" "+ship.getProductionYear());
        }
    }

    private static void createShipWithCabins(Session session) {
        Transaction tx = session.beginTransaction();
        Random random = new Random();
        Ship ship = new Ship();
        ship.setCabins(new HashSet<>());
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
            ship.getCabins().add(cabin);
        }
        session.save(ship);
        tx.commit();
    }
}
