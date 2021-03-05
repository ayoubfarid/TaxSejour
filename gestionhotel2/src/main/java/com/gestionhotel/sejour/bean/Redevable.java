 package com.gestionhotel.sejour.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToOne
    private TypeRedevable type;
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    public TypeRedevable getType() {
        return type;
    }
    public void setType(TypeRedevable type) {
        this.type = type;}
}