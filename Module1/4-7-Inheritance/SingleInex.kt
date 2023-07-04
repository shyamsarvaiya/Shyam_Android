open class A
{
    fun a1()
    {
        println("a1 called")
    }
}
class B : A()
{
    fun b1()
    {
        println("b1 called")
    }
}
fun main()
{

    var b1 = B()

    b1.a1()
    b1.b1()

}