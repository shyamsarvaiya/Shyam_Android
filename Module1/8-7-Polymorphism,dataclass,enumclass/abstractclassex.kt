class Stu1
{
    fun s1()
    {
        println("student called")
    }

}

abstract class Stu2
 {
     fun s1()
     {
         println("student called")
     }

     abstract fun s2() //without body part
 }

class Stu3 : Stu2()
{
    override fun s2()
    {
        println("s2 called")
    }

}

 fun main()
{
    var s = Stu1()
    s.s1()

    var s2 = Stu3()
    s2.s2()
}