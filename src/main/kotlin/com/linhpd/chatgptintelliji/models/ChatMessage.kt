package com.linhpd.chatgptintelliji.models

data class ChatMessage(
    val question: String,
    val answer: String,
    val timestamp: Long
)