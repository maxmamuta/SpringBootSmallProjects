package com.example.demo.repositories;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by maxmamuta on 9/14/17.
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {

    List<Journal> findByCreatedAfter(Date date);

    @Query("select j from Journal j where j.title like %?1%")
    List<Journal> findByCustomQuery(String word);
}
