package co.edu.uco.ucobet.generales.domain;

import java.io.Serializable;

public class Message implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String content;
    
    public Message() {
        // Constructor sin argumentos
    }

    // Constructor
    public Message(final String id,final String content) {
        this.id = id;
        this.content = content;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}