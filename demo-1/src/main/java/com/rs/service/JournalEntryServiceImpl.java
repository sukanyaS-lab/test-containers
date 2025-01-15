package com.rs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.JournalEntry;
import com.rs.repository.JournalRepository;
import com.rs.service.JournalEntryService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

	@Autowired
	private JournalRepository repo;

//	@PersistenceContext
//	EntityManager entityManager;

	@Override
	public List<JournalEntry> getAllEntries() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public JournalEntry saveEntry(JournalEntry journalEntry) {
//	    if (journalEntry.getId() != null) {
//	        JournalEntry existingEntry = repo.findById(journalEntry.getId()).orElseThrow();
//	        // Update fields here...
//	        existingEntry.setContent(journalEntry.getContent());
//	        // No need to manually set version; Hibernate will handle it
//	        return repo.save(existingEntry);
//	    }
	    
//	    JournalEntry existingEntry = repo.findById(journalEntry.getId()).orElseThrow();
	       
	    return repo.save(journalEntry);
	}

}
