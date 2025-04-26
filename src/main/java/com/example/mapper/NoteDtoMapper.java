package com.example.mapper;

import com.example.Note;
import com.example.dto.NoteRequestDto;
import com.example.dto.NoteResponseDto;

public class NoteDtoMapper {

    public static Note toEntity(NoteRequestDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }

    public static NoteResponseDto toDto(Note note) {
        NoteResponseDto dto = new NoteResponseDto();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        return dto;
    }
}
