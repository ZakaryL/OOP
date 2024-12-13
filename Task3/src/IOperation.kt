interface IOperation
{
    val operator: String

    fun getSign(): String
    fun estimate(a: Double, b: Double): Double
}