package gury.springframework.sfgpetclinic.services;


import gury.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by jt on 7/18/18.
 */
public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);

   List<Owner> findAllByLastNameLike(@Param("lastName") String lastName);
}