package com.example.FirstSpringApp.service;

import com.example.FirstSpringApp.entity.JournalEntry;
import com.example.FirstSpringApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.FirstSpringApp.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry,String userName)
    {
      try {
          User user = userService.findByUserName(userName);
          journalEntry.setDate(LocalDateTime.now());
          JournalEntry saved = journalEntryRepository.save(journalEntry);
          user.getJournalEntries().add(saved);
          userService.saveNewUser(user);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll()
    {
        return journalEntryRepository.findAll();
    }
    public Optional <JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName)
    {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));

            if(removed)
            {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error Occured while deleting the entry.",e);
        }
            return removed;
    }

    public List<JournalEntry> findByUserName(String userName)
    {};
}
