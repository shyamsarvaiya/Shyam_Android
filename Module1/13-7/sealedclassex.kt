sealed class A11
{
    class B :A11()
    object C :A11()
}

fun main()
{
     val x: A11 = A11.C
    val output = when(x)
    {
        is A11.B->"B class"
        is A11.C->"object"
    }
    println(output)
}