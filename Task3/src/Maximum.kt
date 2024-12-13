class Maximum: IOperation
{
    override val operator = "MAX"

    override fun getSign(): String {
        return operator
    }

    override fun estimate(a: Double, b: Double):Double
    {
        if(a > b) return a
        else return b
    }
}