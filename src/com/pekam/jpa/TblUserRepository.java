package com.pekam.jpa;


import com.pekam.entities.TblUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TblUserRepository extends CrudRepository<TblUser, Long> {

    List<TblUser> findAll();
    TblUser findById(long id);
}


