package kr.co.eastflag.websocket.controller;

import kr.co.eastflag.redis.service.RedisPublisher;
import kr.co.eastflag.websocket.dto.ChatMessage;
import kr.co.eastflag.websocket.service.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

// Publisher
@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {
    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * websocket /pub/chat/message 로 들어오는 메시지를 처리
     * @param message
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + " joined");
        }

        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message.getMessage());
    }
}
