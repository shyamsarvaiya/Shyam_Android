import java.io.IOException
import java.lang.NumberFormatException

fun main()
{

    var age = 15

    if(age>=18)
    {
        print("Eligible")
    }
    else
    {
        //print("Not Eligible")
        throw ArithmeticException("Not Eligible1")
        throw IOException("Not Eligible2")
        throw NumberFormatException("Not Eligible3")
        throw ArrayIndexOutOfBoundsException("Not Eligible4")
    }


}