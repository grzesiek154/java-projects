import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSystem {


    public static void main(String[] args) {
        boolean isOnList = true;
        boolean isAbove = false;
        int limit = 50;
        int value = 60;

        if(isOnList) {
            if(isAbove && limit >  value) {
                System.out.println("above limit");
            } else if (!isAbove && limit < value) {
                System.out.println("below limit");
            }
        }
    }


}
