package com.linhpd.chatgptintelliji.ui.toolwindows

import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextField
import com.vladsch.flexmark.util.html.ui.Color
import org.apache.commons.lang3.StringUtils
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.*

class ChatGPTToolWindow : JComponent() {

    private val panel: JPanel = JPanel()
    private val messageContainer = JPanel().apply {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
    }
    private val options = arrayOf("Option 1", "Option 2", "Option 3")

    init {
        val boxLayout = BoxLayout(panel, BoxLayout.Y_AXIS)
        panel.layout = boxLayout
        panel.add(InputPanel(options) { input ->
            handleEnterPress(input)
        })
        panel.add(JBScrollPane(messageContainer).apply {
            alignmentX = LEFT_ALIGNMENT
            preferredSize = Dimension(Int.MAX_VALUE, Int.MAX_VALUE) // Adjust height as needed
        })

        panel.add(Box.createVerticalGlue())
    }

    fun getContent() = panel

    private fun handleEnterPress(text: String) {
        if (text.isNotEmpty()) {
            val card = MessagePanel(text, text)
            messageContainer.add(card, 0)
            messageContainer.revalidate()
            messageContainer.repaint()
        }
    }
}

class InputPanel(
    options: Array<String>,
    handleEnterPress: (String) -> Unit
) : JPanel(BorderLayout(2, 0)) {

    init {
        alignmentX = LEFT_ALIGNMENT
        maximumSize = Dimension(Int.MAX_VALUE, preferredSize.height)

        add(JBTextField().apply {
            emptyText.text = "Ask ChatGPT something"
            foreground = Color.GRAY
            alignmentX = LEFT_ALIGNMENT
            maximumSize = Dimension(Int.MAX_VALUE, preferredSize.height)

            addKeyListener(object : KeyAdapter() {
                override fun keyPressed(e: KeyEvent) {
                    if (e.keyCode == KeyEvent.VK_ENTER) {
                        handleEnterPress(text)
                        text = StringUtils.EMPTY
                    }
                }
            })
        }, BorderLayout.CENTER)

        add(JComboBox(options).apply {
            maximumSize = Dimension(150, preferredSize.height)
        }, BorderLayout.WEST)
    }
}

class MessagePanel(question: String, answer: String) : JPanel(BorderLayout(10, 10)) {

    init {
        // Set up the title label
        val titleLabel = JLabel(question)

        // Set up the body text area
        val bodyTextArea = JTextArea(answer)
        bodyTextArea.lineWrap = true
        bodyTextArea.wrapStyleWord = true
        bodyTextArea.isEditable = false
        bodyTextArea.background = this.background

        // Add title and body to the panel
        add(titleLabel, BorderLayout.NORTH)
        add(bodyTextArea, BorderLayout.CENTER)

        // Set preferred size and border
//        preferredSize = Dimension(300, 200)
        border = BorderFactory.createLineBorder(Color.BLACK)
    }
}
