import java.awt.Color
import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.JPanel

class Ball: Thread
{
    private var panel: JPanel
    private var step: Int
    private var size: Int
    private var x: Int
    private var y: Int
    private var xdir: Int = 1
    private var ydir: Int = 1

    constructor(_panel:JPanel, _step: Int, _size: Int, _x: Int, _y: Int) {
        panel = _panel
        step = _step
        size = _size
        x = _x
        y = _y
    }

    override fun run() {
        var gr = panel.graphics
        panel.background = Color.WHITE
        while(true)
        {
            gr.apply {
                color = Color.CYAN
                fillOval(x, y, size, size)
            }

            try {
                Thread.sleep(30)
            }catch (e: InterruptedException){
                e.printStackTrace()
            }

            gr.apply {
                color = Color.WHITE
                fillOval(x, y, size, size)
            }
            if(x>panel.width-size) xdir=-1
            if(x<size) xdir = 1
            if(y>panel.height-size) ydir=-1
            if(y<size) ydir = 1

            x+=xdir*step
            y+=ydir*step
        }
    }
}

fun main()
{
    val frame = JFrame()
    frame.apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(500, 500)
        setLocation(200, 200)
        layout = GridLayout()
    }
    val panel = JPanel()
    frame.add(panel)
    frame.isVisible = true

    val ball1 = Ball(panel, 2, 50, 200, 40)
    val ball2 = Ball(panel, 10, 10, 100, 50)
    val ball3 = Ball(panel, 5, 20, 30, 30)
    ball1.start()
    ball2.start()
    ball3.start()
}