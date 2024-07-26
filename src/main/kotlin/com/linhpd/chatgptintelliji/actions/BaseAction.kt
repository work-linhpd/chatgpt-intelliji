package com.linhpd.chatgptintelliji.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

abstract class BaseAction : AnAction() {
    fun project(event: AnActionEvent): Project {
        return event.project ?: throw Exception("Project is null")
    }

    fun editor(event: AnActionEvent): Editor {
        return event.getData(CommonDataKeys.EDITOR) ?: throw Exception("EDITOR is null")
    }

    fun showErrorMessage(
        event: AnActionEvent,
        message: String,
        title: String = "Error"
    ) {
        Messages.showMessageDialog(
            project(event),
            message,
            title,
            Messages.getErrorIcon()
        )
    }

    fun showInfoMessage(
        event: AnActionEvent,
        message: String?,
        title: String = "Info"
    ) {
        Messages.showMessageDialog(
            project(event),
            message ?: "Empty message",
            title,
            Messages.getInformationIcon()
        )
    }
}