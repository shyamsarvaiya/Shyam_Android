fun main()
{
    //duplicate value remove
    var data = setOf<String>("a","b","c","d","a")
    println(data)


    for(i in data)
    {
        println(i)
    }

    println("---------------------------")

    var data2 = setOf("a","b","c","d",12,3)

    println(data2)


    for(i in data2)
    {
        println(i)
    }

}