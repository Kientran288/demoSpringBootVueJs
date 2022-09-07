package com.example.demo.controller;

import com.example.demo.models.Checkbox;
import com.example.demo.models.Note;
import com.example.demo.payload.request.CheckboxRequest;
import com.example.demo.payload.request.NoteRequest;
import com.example.demo.payload.response.NoteResponse;
import com.example.demo.repository.CheckboxRepository;
import com.example.demo.repository.NoteRepository;
import com.example.demo.services.FilesStorageService;
import com.example.demo.services.NoteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

@CrossOrigin("*")
@RestController
@Log4j2
@RequestMapping("/api-kientt-note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<NoteResponse>> getAllNote(@RequestParam(required = false) String title, Principal principal) {
        return noteService.getAllNote(title, principal);
    }


    @GetMapping("/note/{id}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable("id") long id) {
        return noteService.detail(id);
    }

    @PostMapping(value = "/notes", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Note> createNote(@RequestPart("note") NoteRequest noteRequest, @RequestPart("file") MultipartFile file, Principal principal) {
        return noteService.create(noteRequest, file, principal);
    }

    @PutMapping(value = "/notes/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Note> updateNote(@PathVariable("id") long id,@RequestPart("note") NoteRequest noteRequest, @RequestPart("file") MultipartFile file) {
        return noteService.edit(id, noteRequest, file);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") long id) {
        return noteService.delete(id);
    }

    @DeleteMapping("/notes")
    public ResponseEntity<HttpStatus> deleteAllNotes() {
        return noteService.deleteAll();
    }

}
