package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.domain.Message;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.MessageService;

@RestController
@RequestMapping("/general/api/v1/messages")
public class MessageController {
    private final MessageService messageService;

    
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMessage(
            @PathVariable String id,
            @RequestBody Message updatedMessage) {
        updatedMessage.setId(id); // Establece el ID del mensaje
        messageService.addMessage(updatedMessage); // Llama al servicio para guardar el mensaje
        return ResponseEntity.ok("Mensaje actualizado exitosamente");
    }

    @PostMapping
    public void createMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable String id) {
        return messageService.getMessage(id);
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
    }
}
