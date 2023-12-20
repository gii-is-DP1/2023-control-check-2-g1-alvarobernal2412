package org.springframework.samples.petclinic.disease;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.samples.petclinic.model.NamedEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Symptom extends NamedEntity{
    String description;
    
    @ManyToMany
    Set<Disease> includes;
    
    @ManyToMany
    Set<Disease> excludes;
}
