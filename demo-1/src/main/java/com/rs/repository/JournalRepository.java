package com.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.entity.JournalEntry;


@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Long>{

}
