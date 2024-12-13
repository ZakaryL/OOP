import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class Gui{

    private var frame : JFrame = JFrame()
    private var calc : JButton
    private var operator : JComboBox<Any>
    private var res: JLabel
    private var a: JTextField
    private var b: JTextField
    private var operations: Array<IOperation>

    init{
        frame.apply {
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            setSize(500,200)
            title = "Float operations"
            layout = GridLayout(3,5, 20,10)
        }
        a = JTextField("").apply {
            horizontalAlignment = JLabel.CENTER
        }
        b = JTextField("").apply {
            horizontalAlignment = JLabel.CENTER
        }

        operations = arrayOf(Maximum(), Minimum(), Module(), Add(), Sub(), Mul(), Div())

        operator = JComboBox(arrayOf(operations[0].getSign(), operations[1].getSign(), operations[2].getSign(),
            operations[3].getSign(), operations[4].getSign(), operations[5].getSign(), operations[6].getSign()))

        calc = JButton("=").apply {
            actionCommand = "Calculate"
            addActionListener(ButtonClickListener())
        }

        res = JLabel("")
        res.horizontalAlignment = JLabel.CENTER

        for (i in 0..4)
            frame.add(JLabel(""))

        frame.add(a)
        frame.add(operator)
        frame.add(b)
        frame.add(calc)
        frame.add(res)

        for (i in 0..4)
            frame.add(JLabel(""))

        frame.isVisible = true
    }
    private inner class ButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(e.actionCommand == "Calculate")
            {
                for (i in operations)
                    if (i.getSign() == operator.selectedItem)
                        res.text = "    " + i.estimate(a.text.toDouble(), b.text.toDouble()).toString()

            }

        }
    }

}


fun main()
{
    Gui()
}