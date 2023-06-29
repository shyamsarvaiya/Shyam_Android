class MyFirstClass
{
    fun addTwoNum(a: Int , b : Int, action: (Int) ->Unit)
    {
        val sum = a+b
        action(sum)
    }
}
fun main()
{
    var m1 = MyFirstClass()
    //lambda expression
    val myLambda : (Int) -> Unit={s : Int ->println(s)}
    m1.addTwoNum(6,5,myLambda)

}