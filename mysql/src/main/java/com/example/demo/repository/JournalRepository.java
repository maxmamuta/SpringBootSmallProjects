package com.example.demo.repository;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by maxmamuta on 9/16/17.
 */
@Transactional
@RepositoryRestResource(collectionResourceRel = "entry", path = "journal")
public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date);
    List<Journal> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date after,
                                       @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);
    List<Journal> findByTitleContaining(@Param("word") String word);
    List<Journal> findBySummaryContaining(@Param("word") String word);
}
