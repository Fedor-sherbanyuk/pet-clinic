package gury.springframework.sfgpetclinic.services;

import gury.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

   Owner findByLastName(String lastName);




}
