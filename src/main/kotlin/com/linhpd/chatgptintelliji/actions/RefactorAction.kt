package com.linhpd.chatgptintelliji.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


class RefactorAction : BaseAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val selectedText = editor(event).selectionModel.selectedText
        Messages.showMessageDialog(
            project(event),
            selectedText,
            "ChatGPT said:",
            Messages.getInformationIcon()
        )
    }

}