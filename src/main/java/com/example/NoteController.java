package com.example;

import com.example.dto.NoteRequestDto;
import com.example.dto.NoteResponseDto;
import com.example.mapper.NoteDtoMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteResponseDto> getAllNotes() {
        return noteService.getAllNotes().stream()
                .map(NoteDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NoteResponseDto getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        return NoteDtoMapper.toDto(note);
    }

    @PostMapping
    public NoteResponseDto createNote(@RequestBody NoteRequestDto requestDto) {
        Note note = NoteDtoMapper.toEntity(requestDto);
        return NoteDtoMapper.toDto(noteService.createOrUpdateNote(note));
    }

    @PutMapping("/{id}")
    public NoteResponseDto updateNote(@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        Note note = NoteDtoMapper.toEntity(requestDto);
        note.setId(id);
        return NoteDtoMapper.toDto(noteService.createOrUpdateNote(note));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }
}
