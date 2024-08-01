package com.linhpd.chatgptintelliji.actions

import com.intellij.diff.DiffContentFactory
import com.intellij.diff.DiffManager
import com.intellij.diff.requests.SimpleDiffRequest
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project

class ExplainAction : BaseAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val selectionModel = editor(event).selectionModel
        if (!selectionModel.hasSelection()) {
            showErrorMessage(event, "No text selected", "Error")
        } else {
            showMergeTool(project(event), selectionModel.selectedText!!)
        }
    }

    private fun showMergeTool(project: Project, generatedText: String) {
        val editor = FileEditorManager.getInstance(project).selectedTextEditor ?: return
        val document = editor.document
        val currentText = document.text

        val diffContent1 = DiffContentFactory.getInstance().create(currentText)
        val diffContent2 = DiffContentFactory.getInstance().create(generatedText)

        val request = SimpleDiffRequest(
            "Merge ChatGPT Response",
            diffContent1,
            diffContent1,
            diffContent2,
            "Original Editor Content",
            "Current Editor Content",
            "ChatGPT Generated Content"
        )

        DiffManager.getInstance().showDiff(project, request)
    }
}