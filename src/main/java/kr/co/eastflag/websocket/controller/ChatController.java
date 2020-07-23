package kr.co.eastflag.websocket.controller;

import kr.co.eastflag.websocket.dto.ChatRoom;
import kr.co.eastflag.websocket.config.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> roomList = chatService.findAllRoom();
        log.debug("rooms : {}", roomList);
        System.out.println("rooms: " + roomList);
        return roomList;
    }
}
