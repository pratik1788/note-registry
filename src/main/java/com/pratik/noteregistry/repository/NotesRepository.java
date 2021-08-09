package com.pratik.noteregistry.repository;

import com.pratik.noteregistry.pojo.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Note,String> {
}
