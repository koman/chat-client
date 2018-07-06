package com.bmw.chat.client.chatroom.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.chat.client.chatroom.domain.model.ChatRoom;
import com.bmw.chat.client.chatroom.domain.model.InstantMessage;
import com.bmw.chat.client.chatroom.domain.repository.InstantMessageRepository;

@Service
public class CassandraInstantMessageService implements InstantMessageService {

	@Autowired
	private InstantMessageRepository instantMessageRepository;
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	@Override
	public void appendInstantMessageToConversations(InstantMessage instantMessage) {
		if (instantMessage.getText().contains("joined us :)") || instantMessage.getText().contains("left us :(")) {
			return;
		}
		if (instantMessage.isFromAdmin() || instantMessage.isPublic()) {
			ChatRoom chatRoom = chatRoomService.findById(instantMessage.getChatRoomId());
			
			chatRoom.getConnectedUsers().forEach(connectedUser -> {
				instantMessage.appendToUserConversation(connectedUser.getUsername());
				instantMessageRepository.save(instantMessage);
			});
		} else {
			instantMessage.appendToUserConversation(instantMessage.getFromUser());
			instantMessageRepository.save(instantMessage);
			
			instantMessage.appendToUserConversation(instantMessage.getToUser());
			instantMessageRepository.save(instantMessage);
		}
	}

	@Override
	public List<InstantMessage> findAllInstantMessagesFor(String username, String chatRoomId) {
		return instantMessageRepository.findInstantMessagesByUsernameAndChatRoomId(username, chatRoomId);
	}
}
