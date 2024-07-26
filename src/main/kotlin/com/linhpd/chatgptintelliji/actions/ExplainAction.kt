package com.linhpd.chatgptintelliji.actions

import com.intellij.openapi.actionSystem.AnActionEvent

class ExplainAction : BaseAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val selectionModel = editor(event).selectionModel
        if (!selectionModel.hasSelection()) {
            showErrorMessage(event, "No text selected", "Error")
        } else {
            showInfoMessage(event, selectionModel.selectedText)
        }
    }
}