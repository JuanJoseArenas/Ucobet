package co.edu.uco.ucobet.generales.aplication.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.domain.Message;

@Repository
public class MessageRepository {
    private final RedisTemplate<String, Message> redisTemplate;

    public MessageRepository(RedisTemplate<String, Message> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveMessage(Message message) {
        redisTemplate.opsForValue().set(message.getId(), message);
    }

    public Message getMessage(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    public List<Message> getAllMessages() {
        Set<String> keys = redisTemplate.keys("*");
        List<Message> messages = new ArrayList<>();
        
        if (keys != null) {
            for (String key : keys) {
                Message message = redisTemplate.opsForValue().get(key);
                if (message != null) {
                    messages.add(message);
                }
            }
        }
        
        return messages;
    }

    public void deleteMessage(String id) {
        redisTemplate.delete(id);
    }
}