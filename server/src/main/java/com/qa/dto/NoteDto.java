package com.qa.dto;

import com.qa.persistence.model.Note;

public class NoteDto {

	Long id;
	String text;
	
	public NoteDto() {
		super();
	}

	public NoteDto(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public NoteDto(Note note) {
		this.id = note.getId();
		this.text = note.getText();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
