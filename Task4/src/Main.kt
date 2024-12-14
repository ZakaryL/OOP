import jdk.jfr.Enabled
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.event.CaretEvent
import javax.swing.event.CaretListener

fun calculate(str: String, num: Any?):String
{
    var char = str.toCharArray()
    var text: String = ""
    for (i in 0..<char.size)
    {
        text = text + char[i]+"*"+num+"^"+(char.size-i-1)
        if(i!=(char.size-1))
            text = text + "+"
    }

    return text
}

fun translate(str: String, num: Any?):String
{
    var text: String = ""
    when(num)
    {
        "10" -> text = str
        "2" -> text = Integer.toBinaryString(str.toInt())
        "8" -> text = Integer.toOctalString(str.toInt())
        "16" -> text = Integer.toHexString(str.toInt())
    }
    return text
}

class Gui{

    private var frame : JFrame = JFrame()
    private var text: Array<JLabel>
    private var field: JTextField
    private var res: JLabel
    private var system: JComboBox<String>
    private var check: JCheckBox
    private var calc: JLabel

    init{
        frame.apply {
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            setSize(700,300)
            title = "Binary Calculator"
            layout = GridLayout(4,2, 20,20)

        }
        text = arrayOf(JLabel("Ваше число в десят. СС"), JLabel("Система счисления"), JLabel("Результат"))
        field = JTextField("").apply {
            horizontalAlignment = JLabel.CENTER
            addCaretListener(WriteText())
        }

        system = JComboBox(arrayOf("10", "2", "8", "16")).apply {
            addActionListener(ChooseComboBox())
        }

        check = JCheckBox("Показать перевод в десятичную").apply {
            addActionListener(CheckEvent())
        }

        calc = JLabel("").apply {
            horizontalAlignment = JLabel.CENTER
            isVisible = false
        }

        res = JLabel("")
        res.horizontalAlignment = JLabel.CENTER


        frame.add(text[0])
        frame.add(field)

        frame.add(text[1])
        frame.add(system)

        frame.add(text[2])
        frame.add(res)

        frame.add(check)
        frame.add(calc)

        frame.isVisible = true
    }
    private inner class WriteText : CaretListener {
        override fun caretUpdate(e: CaretEvent) {
            if(field.text != "")
            {
                res.text = translate(field.text, system.selectedItem)
                calc.text = calculate(res.text, system.selectedItem)
            }
            else
                res.text = field.text
        }
    }
    private inner class ChooseComboBox : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(field.text != "")
            {
                res.text = translate(field.text, system.selectedItem)
                calc.text = calculate(res.text, system.selectedItem)
            }
            else
                res.text = field.text
        }
    }
    private inner class CheckEvent : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(check.isSelected)
                calc.isVisible = true
            else
                calc.isVisible = false
        }
    }

}


fun main()
{
    Gui()
}