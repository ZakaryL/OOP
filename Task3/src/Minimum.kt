class Minimum: IOperation
{
    override val operator = "MIN"

    override fun getSign(): String {
        return operator
    }

    override fun estimate(a: Double, b: Double):Double
    {
        if(a < b) return a
        else return b
    }
}