fun main()
{
    var email = "shyam@gmail.com"
    var pass = "1234"

    println("Enter Your Email")
    var e = readLine()

    println("Enter Your Password")
    var p = readLine()

    if(e.equals(email) && p.equals(pass))
    {
        println("logged in")
    }
    else
    {
        println("error")
    }
}