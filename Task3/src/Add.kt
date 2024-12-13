class Add : IOperation
{
    override val operator = "+"

    override fun getSign(): String {
        return operator
    }

    override fun estimate(a: Double, b: Double):Double
    {
        return a+b
    }
}