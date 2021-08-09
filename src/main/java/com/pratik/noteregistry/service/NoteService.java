package com.pratik.noteregistry.service;

import com.pratik.noteregistry.pojo.Note;
import com.pratik.noteregistry.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Collections;
import java.util.List;

@Service
public class NoteService implements INoteService{

    @Autowired
    private NotesRepository notesRepository;
    private Parser parser = Parser.builder().build();
    private HtmlRenderer renderer = HtmlRenderer.builder().build();

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = notesRepository.findAll();
        Collections.reverse(notes);
        return notes;
    }

    @Override
    public Note saveNote(String description) {
        Note note=null;
        if (description != null && !description.trim().isEmpty()) {
            Node document = parser.parse(description.trim());
            String html = renderer.render(document);
            note=new Note(null, html);
            notesRepository.save(note);
            //After publish you need to clean up the textarea

        }
        return note;
    }
}
