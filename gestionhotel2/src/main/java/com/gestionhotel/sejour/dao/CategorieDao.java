package com.gestionhotel.sejour.dao;

import com.gestionhotel.sejour.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie,Long> {
    public Categorie findByRef(String r);
    public Categorie findByLibelle(String l);

    int countByRef(String ref);
}
