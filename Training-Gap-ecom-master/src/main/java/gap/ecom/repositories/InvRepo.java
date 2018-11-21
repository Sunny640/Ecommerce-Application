package gap.ecom.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gap.ecom.inventory.*;
@Repository
public interface InvRepo extends CrudRepository<InvModel,Long>{


}
