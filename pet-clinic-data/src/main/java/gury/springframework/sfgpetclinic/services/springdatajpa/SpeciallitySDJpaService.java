package gury.springframework.sfgpetclinic.services.springdatajpa;

import gury.springframework.sfgpetclinic.model.Speciality;
import gury.springframework.sfgpetclinic.repositories.SpecialityRepository;
import gury.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpeciallitySDJpaService implements SpecialityService {
    private  final SpecialityRepository specialityRepository;

    public SpeciallitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities =new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);

    }

    @Override
    public void deleteByID(Long aLong) {
        specialityRepository.deleteById(aLong);

    }
}
