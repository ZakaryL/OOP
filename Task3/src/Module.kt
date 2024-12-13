class Module: IOperation
{
    override val operator = "DIST"

    override fun getSign(): String {
        return operator
    }

    override fun estimate(a: Double, b: Double):Double
    {
        var c: Double
        if(a < b)
            c = b - a
        else
            c = a - b

        return c
    }
}