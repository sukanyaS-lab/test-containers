package com.rs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.JournalEntry;
import com.rs.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
	
	@Autowired
	private JournalEntryService service;
	
	private Map<Long, JournalEntry> journalEntries = new HashMap<Long, JournalEntry> ();
	
	
	@GetMapping  //localhost:1200/journal -> get request
	public List<JournalEntry> getAll(){
//		return new ArrayList<>(journalEntries.values()); 
		return new ArrayList<>(service.getAllEntries());
	}
	
	@PostMapping //localhost:1200/journal -> post request
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
//		journalEntries.put(myEntry.getId(), myEntry);
		service.saveEntry(myEntry);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable Long myId) {
		return journalEntries.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public boolean deleteJournalEntryById(@PathVariable Long myId) {
		journalEntries.remove(myId);
		return true;
	}
	
	@PutMapping("id/{myId}")
	public JournalEntry updateJournalById(@PathVariable Long myId, 
			@RequestBody JournalEntry myEntry) {
		return journalEntries.put(myId, myEntry);
//		return true;
	}

}
