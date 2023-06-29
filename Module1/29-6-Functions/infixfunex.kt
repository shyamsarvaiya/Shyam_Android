class Student2
{

    fun haspassed(marks:Int):Boolean
    {
        return marks>40
    }



}

//Extension function

infix fun Student2.isscholarship(marks: Int):Boolean
{
    return marks>90
}

fun main()
{

    var s = Student()
    println("Pass Status:"+s.haspassed(35))
    println("Scholarship Status:"+s.isscholarship(35))

}