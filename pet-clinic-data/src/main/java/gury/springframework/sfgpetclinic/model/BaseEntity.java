package gury.springframework.sfgpetclinic.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
