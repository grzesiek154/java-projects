import javax.persistence.*;
import java.util.List;

public class TestSystem {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("DerekBanasHibernateAndJPA");

    public static void main(String[] args) {
        System.out.println("testing start");
        addCustomer(1, "Jan", "Kowalski");
        addCustomer(2, "Adam", "Nowak");
        getCustomers();
        getCustomer(1);
        getCustomers();

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void addCustomer(int id, String fname, String lname) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Customer customer = new Customer();
            customer.setId(id);
            customer.setfName(fname);
            customer.setlName(lname);

            em.persist(customer);
            et.commit();
            System.out.println("customer added");

        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        }finally {
            em.close();
        }
    }

    public static void getCustomer(int id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Customer c WHERE c.id = :custID";

        TypedQuery<Customer> tq = em.createQuery(query,Customer.class);
        tq.setParameter("custID", id);
        Customer customer = null;
        try {
            customer = tq.getSingleResult();
            System.out.println(customer.getfName() + " " + customer.getfName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void getCustomers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        // :custID is a parameterized query thats value is set below
        String strQuery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";

        // Issue the query and get a matching Customer
        TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
        List<Customer> custs;
        try {
            // Get matching customer object and output
            custs = tq.getResultList();
            custs.forEach(cust->System.out.println(cust.getfName() + " " + cust.getlName()));
        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public static void changeFName(int id, String fname) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = null;
        Customer customer = null;

        try {
            et = em.getTransaction();
            et.begin();
            customer = em.find(Customer.class, id);
            customer.setfName(fname);

            em.persist(customer);
            et.commit();

        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        }finally {
            em.close();
        }
    }
    public static void deleteCustomer(int id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer cust = null;

        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Customer.class, id);
            em.remove(cust);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
}
