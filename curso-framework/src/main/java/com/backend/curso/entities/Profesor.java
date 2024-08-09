package com.backend.curso.entities;

import java.io.Serializable;
import com.backend.curso.models.ProfesorModel;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profesor")
@SequenceGenerator(name = "profesor_seq", allocationSize = 1)
@AttributeOverrides({
    @AttributeOverride(name="nombre", column= @Column(name = "nombre", length = 45, nullable = false))
})
public class Profesor extends Persona implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    private Long id;

    public Profesor(ProfesorModel model) {
        this.setNombre(model.getNombre());
        this.setApellidoPaterno(model.getApellidoPaterno());
        this.setApellidoMaterno(model.getApellidoMaterno());
        this.setCurp(model.getCurp());
    }
}
