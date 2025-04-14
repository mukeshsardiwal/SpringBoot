package com.example.FirstSpringApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;

@Document(collection = "journal_entries")
@Data

public class JournalEntry
{
    @Id
    private ObjectId id;
    private String title;
    private LocalDateTime date;
    private String content;
}
