package gury.springframework.sfgpetclinic.formatter;

import gury.springframework.sfgpetclinic.model.PetType;
import gury.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

<<<<<<< HEAD
@Component
public class PetTypeFormatter implements Formatter<PetType> {
=======
/**
 * Created by jt on 9/22/18.
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

>>>>>>> e3c5a98 (add /Update Pet Not working. Closes #66)
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> e3c5a98 (add /Update Pet Not working. Closes #66)
