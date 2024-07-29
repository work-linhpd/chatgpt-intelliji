package com.linhpd.chatgptintelliji.ui.components

import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JComboBox
import javax.swing.JLabel
import javax.swing.JPanel

class ChatGPTToolWindow {
    private val panel: JPanel = JPanel()

    init {
        panel.layout = GridBagLayout()
        val gbc = GridBagConstraints().apply {
            fill = GridBagConstraints.HORIZONTAL
            weightx = 0.5
            insets = JBUI.insets(5) // Padding around the components
            gridx
        }

        // Add Model label
        gbc.gridx = 0
        gbc.gridy = 0
        panel.add(JLabel("Model:"), gbc)

        // Add modelComboBox
        gbc.gridx = 2
        gbc.gridy = 0
        gbc.gridwidth = 3
        val modelComboBox = JComboBox(arrayOf("a", "b", "c"))
        panel.add(modelComboBox, gbc)

        // Add askTextField
        gbc.gridx = 0
        gbc.gridy = 1
        gbc.gridwidth = 4
        gbc.fill = GridBagConstraints.HORIZONTAL
        val askTextField = JBTextField().apply {
            emptyText.text = "Ask ChatGPT something"
        }
        panel.add(askTextField, gbc)
    }

    fun getContent() = panel
}
