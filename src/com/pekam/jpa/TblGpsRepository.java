package com.pekam.jpa;


import com.pekam.entities.TblGps;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TblGpsRepository extends CrudRepository<TblGps, Long> {

    List<TblGps> findAll();
    TblGps findById(long id);
}


