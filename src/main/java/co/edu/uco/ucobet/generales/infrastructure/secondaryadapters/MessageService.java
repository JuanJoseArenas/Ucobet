package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.uco.ucobet.generales.aplication.secondaryports.repository.MessageRepository;
import co.edu.uco.ucobet.generales.domain.Message;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        messageRepository.saveMessage(message);
    }

    public Message getMessage(String id) {
        Message message = messageRepository.getMessage(id);
        if (message == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado");
        }
        return message;
    }
    public List<Message> getAllMessages() {
        return messageRepository.getAllMessages();
    }

    public void deleteMessage(String id) {
        messageRepository.deleteMessage(id);
    }
    
    public String getMessageContent(String id) {
        Message message = messageRepository.getMessage(id);
        return message != null ? message.getContent() : "Mensaje no encontrado";
    }
}