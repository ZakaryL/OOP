import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class Gui{

    private var frame : JFrame = JFrame()
    private var calc : JButton
    private var clear : JButton
    private var res: JLabel
    private var matrix: Array<JTextField>

    init{
        frame.apply {
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            setSize(500,500)
            title = "Matrix Determinant"
            layout = GridLayout(4,4, 10,10)
        }
        matrix = arrayOf(
            JTextField(""), JTextField(""),JTextField(""),
            JTextField(""), JTextField(""),JTextField(""),
            JTextField(""), JTextField(""),JTextField("")
        )
        calc = JButton("Calculate").apply {
            actionCommand = "Calculate"
            addActionListener(ButtonClickListener())
        }
        clear = JButton("Clear").apply {
            actionCommand = "Clear"
            addActionListener(ButtonClickListener())
        }
        res = JLabel("")
        res.horizontalAlignment = JLabel.CENTER
        for (i in 0..16)
        {
            if (i<3)
            {
                matrix[i].setHorizontalAlignment(JTextField.CENTER)
                frame.add(matrix[i])
            }
            if (i in 4..6) {
                matrix[i-1].setHorizontalAlignment(JTextField.CENTER)
                frame.add(matrix[i - 1])
            }
            if (i in 8..10) {
                matrix[i-2].setHorizontalAlignment(JTextField.CENTER)
                frame.add(matrix[i - 2])
            }
            if(i==3 || i==11 || i==12 || i==13)
                frame.add(JLabel(""))
            if(i==7)
                frame.add(res)
            if(i==14)
                frame.add(clear)
            if(i==15)
                frame.add(calc)

        }


        frame.isVisible = true
    }
    private inner class ButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            if(e.actionCommand == "Calculate")
            {
                val a1 = matrix[0].text.toDouble()*(matrix[4].text.toDouble()*matrix[8].text.toDouble()-matrix[7].text.toDouble()*matrix[5].text.toDouble())
                val a2 = -matrix[3].text.toDouble()*(matrix[1].text.toDouble()*matrix[8].text.toDouble()-matrix[7].text.toDouble()*matrix[2].text.toDouble())
                val a3 = matrix[6].text.toDouble()*(matrix[1].text.toDouble()*matrix[5].text.toDouble()-matrix[2].text.toDouble()*matrix[4].text.toDouble())
                res.text = "    " + (a1+a2+a3).toString()
            }
            if(e.actionCommand == "Clear")
            {
                for(i in 0..8)
                    matrix[i].text = ""
                res.text = ""
            }
        }
    }

}


fun main()
{
    Gui()
}