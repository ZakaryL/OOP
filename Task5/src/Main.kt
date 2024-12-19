import java.io.File
import java.io.FileNotFoundException

fun main()
{
    println("Введите имя файла")
    val file = File(readlnOrNull().toString())

    try{
        val lines = file.readLines()
        println(lines)
    }
    catch(e: FileNotFoundException)
    {
        println("Файл не найден")
    }
    catch(e: Exception)
    {
        println("Неизвестная ошибка")
    }

}



