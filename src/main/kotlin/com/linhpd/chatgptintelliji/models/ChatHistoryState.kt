package com.linhpd.chatgptintelliji.models

data class ChatHistoryState(
    val messages: MutableList<ChatMessage> = mutableListOf()
)
