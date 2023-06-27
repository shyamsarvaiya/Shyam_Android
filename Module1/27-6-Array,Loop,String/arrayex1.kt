fun main()
{

    var num1 = arrayOf(1,2,4,5)
    //println(num1.toString())
    for(i in num1)
    {
        println(i)
    }
    println("------------------")
    var num2 = arrayOf(1,2,4,5,5.6,7.8,"a",'t',"rfjesfj")

    for(i in num2)
    {
        println(i)
    }

    println("------------------------")

    var num3 = intArrayOf(1,2)
    for(i in num3)
    {
        println(i)
    }

    println(num3[1])

    num3[1] = 6

    println(num3[1])
    println("${num3.size}")
    println("${num3.contains(9)}")


}