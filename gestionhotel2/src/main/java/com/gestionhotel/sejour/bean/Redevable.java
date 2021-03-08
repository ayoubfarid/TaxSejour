 package com.gestionhotel.sejour.bean;

import javax.persistence.*;

 @Entity
public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToOne
    private RedevableType type;
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public RedevableType getType() {
        return type;
    }
    public void setType(RedevableType type) {
        this.type = type;}
}