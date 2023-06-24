fun main()
{
    var age = 56

    if(age>=18) {
        println("Elibile to vote")

        //nested if
        if(age>=50)
        {
            println("Senior citizen")
        }
        else
        {
            println("Young Age")
        }
    }
    else
    {
        println("Not Elibile to vote")
    }

}