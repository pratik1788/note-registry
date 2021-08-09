package com.pratik.noteregistry.service;

import com.pratik.noteregistry.pojo.Note;
import org.springframework.ui.Model;

import java.util.List;

public interface INoteService {
     List<Note> getAllNotes();
     Note saveNote(String description);

}
