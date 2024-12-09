open class M
{
    fun m1()
    {
        println("m1 called")
    }
}
open class N :M()
{
    fun n1()
    {
        println("n1 called")
    }
}
interface K
{
    fun k1()
    {
        println("k1 called")
    }
}
class L : N(),K
{
    fun l1()
    {
        println("l1 called")
    }
}

fun main()
{
    var l1 = L()
    l1.m1()
    l1.n1()
    l1.k1()
    l1.l1()
}