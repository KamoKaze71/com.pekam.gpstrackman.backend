
package com.pekam.jpa;


import com.pekam.entities.TblTracks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TblTracksRepository extends CrudRepository<TblTracks, Long> {

    List<TblTracks> findAll();
    TblTracks findById(long id);
}


