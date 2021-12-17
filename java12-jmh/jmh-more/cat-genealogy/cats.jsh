import com.joshcummings.cats.*;
import com.joshcummings.cats.service.*;
Cat phil = new Cat("Phil", null, null);
Cat carol = new Cat("Carol", null, null);
Cat johnny = new Cat("Johnny", phil, carol);
Cat candace = new Cat("Candace", null, null);
Cat jane = new Cat("Jane", phil, carol);
Cat claire = new Cat("Claire", johnny, candace);
DescendentListingCatService service = new DescendentListingCatService();
service.listDescendents(phil);
phil.getChildren()