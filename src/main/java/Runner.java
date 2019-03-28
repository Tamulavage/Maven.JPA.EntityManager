import entities.Artist;
import entities.CD;
import services.CDServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Testing");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDServices services = new CDServices(em);

        Set<Artist> artists = new HashSet<Artist>();
        artists.add(new Artist("John","Lennon","lead Singer"));
        artists.add(new Artist("Ringo","Star","Drums"));

        CD cd = services.createCD(new CD("Yellow Submarine","hippie","1770",artists, 14.99));
        CD cd1 = services.findCD(cd.getId());

        // raise by Object
        services.changeCDPrice(cd1,  1.01);


        // raise by id
         services.changeCDPrice(cd1.getId(), 1.01);

         services.removeCD(cd1.getId());
    }
}
