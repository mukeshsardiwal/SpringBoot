package com.example.FirstSpringApp.repository;

import com.example.FirstSpringApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    // You can define custom query methods here if needed
}


//controller ---> service ---> repository
