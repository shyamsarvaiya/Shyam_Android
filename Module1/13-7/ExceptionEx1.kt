fun main()
{
    try
    {
        var data = 10/0
        print(data)
    }
    catch (e:Exception)
    {
        println(e)
    }
    //always executed
    finally
    {
        print("success")
    }


}