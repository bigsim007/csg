package za.co.bigsim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.bigsim.model.Class;

@Repository
public interface ClassRepository  extends CrudRepository<Class, Long>{

}
