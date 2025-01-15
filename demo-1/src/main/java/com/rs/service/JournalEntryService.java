package com.rs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rs.entity.JournalEntry;

public interface JournalEntryService {

	List<JournalEntry> getAllEntries();

	JournalEntry saveEntry(JournalEntry entry);

}
