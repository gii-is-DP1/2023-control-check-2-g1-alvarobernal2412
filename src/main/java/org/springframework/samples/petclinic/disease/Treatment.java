package org.springframework.samples.petclinic.disease;

import java.util.Set;

import org.springframework.samples.petclinic.model.NamedEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Treatment extends NamedEntity{
    String description;
    @Min(1)
    @NotNull
    Integer dose;
    
    @ManyToMany
    Set<Disease> recommendedFor;
}
