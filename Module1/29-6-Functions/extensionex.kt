import com.sun.org.apache.xpath.internal.operations.Bool

class Student
{

    fun haspassed(marks:Int):Boolean
    {
        return marks>40
    }



}

//Extension function

fun Student.isscholarship(marks: Int):Boolean
{
    return marks>90
}

fun main()
{

    var s = Student()
    println("Pass Status:"+s.haspassed(35))
    println("Scholarship Status:"+s.isscholarship(35))

}