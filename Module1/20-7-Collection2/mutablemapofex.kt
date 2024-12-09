fun main()
{
    var data = mutableMapOf<String,String>("a" to "1","b" to "2","c" to "3")
    data.put("d" , "4")
    print(data)
    print(data.get("d"))

}