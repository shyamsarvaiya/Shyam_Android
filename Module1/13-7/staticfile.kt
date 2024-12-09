class Company
{
    //static
    companion object
    {
        var c_name="Tops Technologies"

        fun a()
        {
            print("a")
        }
    }

}
fun main()
{

    print(Company.c_name)
    Company.a()
}