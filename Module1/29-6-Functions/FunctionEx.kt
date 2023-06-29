//with return type with para
fun a1(a:Int,b:Int):Int
{
    return a+b
}
//with para without return type
fun a2(a:Int,b:Int)
{
   var c=a+b
    println(c)
}
//with return type without para
fun a3():Int
{
    var a=6
    var b=5
    var c=a+b


    return c
}
//without return type without para
fun a4()
{
    var a=6
    var b=5
    var c=a+b
    println(c)
}
fun main()
{
    println(a1(6,5))
    a2(6,5)
    println(a3())
    a4()
}