class Counting(id:Int,name:String)
{
   /* constructor(id:Int,name:String)
    {
        companio
        var count =0
    }*/
        //static - evertime do not allocate new memory
        companion object
        {
                var count =0
        }
        fun data()
        {
            count++
            print(count)
        }
}


fun main()
{

    var c1 = Counting(101,"a")
    var c2 = Counting(102,"b")
    var c3 = Counting(103,"c")

    c1.data()
    c2.data()
    c3.data()

}