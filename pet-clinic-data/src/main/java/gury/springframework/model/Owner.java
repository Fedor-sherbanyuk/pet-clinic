package gury.springframework.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Owner extends Person{
    @Builder
    public Owner(Long id, String firstname, String lastname, String address, String city, String telephone, Set<Pet> pets) {
        super(id,firstname,lastname);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
//    @Column(name = "pets")
    private Set<Pet> pets=new HashSet<>();
}
