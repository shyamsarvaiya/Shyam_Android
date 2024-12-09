data class Student123(var id:Int,var name:String)
{

}

fun main()
{
    var user1 = Student123(101,"abc")
    var user2 =Student123(101,"abc")

    println(user1)
    println(user2)

    if(user1==user2)
    {
        println("Equal")
    }
    else
    {
        println("Not Equal")
    }

    var user3 = user1.copy()
    println(user3)

}