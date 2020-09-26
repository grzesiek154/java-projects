import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSystem {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("DarekBeansJPAandHibernate");

    public static void main(String[] args) {

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void addCustomer(int id, String fname, String lname) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    }


}
