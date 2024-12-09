open class Bank1
{
    open fun roi():Int
    {
        return 0
    }
}
class Sbi : Bank1()
{
    override fun roi():Int
    {
        return 7
    }
}
class Icici : Bank1()
{
    override fun roi():Int
    {
        return 8
    }
}
class Axis : Bank1()
{
    override fun roi():Int
    {
        return 9
    }
}
fun main()
{
    var b1 = Bank1() //refrence variable

    b1 = Sbi()
    println(b1.roi())

    b1 = Icici()
    println(b1.roi())

    b1 = Axis()
    println(b1.roi())

}
