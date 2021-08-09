package com.pratik.noteregistry.controller;

import com.pratik.noteregistry.pojo.Note;
import com.pratik.noteregistry.repository.NotesRepository;
import com.pratik.noteregistry.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class NoteController {

    @Autowired
    INoteService noteService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "index";
    }

    @PostMapping("/note")
    public String saveNotes(@RequestParam("image") MultipartFile file,
                            @RequestParam String description,
                            @RequestParam(required = false) String publish,
                            @RequestParam(required = false) String upload,
                            Model model)  {

        if (publish != null && publish.equals("Publish")) {
            noteService.saveNote(description);
            model.addAttribute("notes", noteService.getAllNotes());
            return "redirect:/";
        }
        // After save fetch all notes again
        return "index";
    }

}
