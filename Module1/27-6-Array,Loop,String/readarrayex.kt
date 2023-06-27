import java.lang.Integer.parseInt

fun main()
{

    var a = IntArray(5)

    for(i in 0..4)
    {
        println("enter number :")
        val data : String?= readLine()
        a[i] = parseInt(data)
    }

    println("Array Element :")

    for(i in 0 .. 4)
    {
        print( " "+a[i])
    }

    println(" 'shyam' ")
}