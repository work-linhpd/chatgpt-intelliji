package com.linhpd.chatgptintelliji.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable


class RefactorAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {

        // Using the event, create and show a dialog
        val currentProject: Project? = event.getProject()
        val message: StringBuilder =
            StringBuilder(event.getPresentation().getText() + " Selected!")

        // If an element is selected in the editor, add info about it.
        val selectedElement: Navigatable? = event.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            "",
            Messages.getInformationIcon()
        )
    }

}