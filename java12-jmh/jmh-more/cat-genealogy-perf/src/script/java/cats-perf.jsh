import com.joshcummings.cats.*;
import com.joshcummings.cats.service.*;
import com.joshcummings.cats.model.*;

void init(CatService service) {

        Random rnd = new Random();

        int numberOfCats = 128;

        for ( int i = 0; i < numberOfCats / 2; i++ ) {

            service.addCat("Cat" + i, null, null);

        }

        

        for ( int i = 0; i < numberOfCats / 2; i++ ) {

            List<Cat> cats = new ArrayList<>(service.listCats());

            Cat dad = cats.get(rnd.nextInt(cats.size()));

            Cat mom = cats.get(rnd.nextInt(cats.size()));

            service.addCat("Cat" + ( i + numberOfCats / 2), dad, mom);

        }

    }
