import java.io.File

class Country
{
    var name = ""
    var area = 1.0
    var language = "english"
    var population = 1.0

    constructor(_name:String, _area:Double, _population:Double)
    {
        name = _name
        area = _area
        population = _population
    }
    constructor(_name:String, _area:Double, _language:String, _population:Double) : this(_name, _area, _population)
    {
        language = _language
    }

    fun Print()
    {
        println(name+": "+area+" (10^6) km^2, "+language+", "+population+" million people")
    }
}

fun main() {
    var list_of_countries = arrayOf(
        Country("Russia", 17.1, "russian", 145.5),
        Country("USA", 9.8, 335.9),
        Country("China", 9.5, "chinese", 1409.6),
        Country("India", 3.3, "hindi", 1428.5),
        Country("UK", 0.2, 68.2),
        Country("Australia", 7.7,  27.5),
        Country("Canada", 9.9, "english, french", 41.3),
        Country("Italy", 0.3, "italian", 58.9),
        Country("Japan", 0.38, "japanese", 124.0),
        Country("Brazil", 8.5, "portuguese", 203.0),
        Country("New Zealand", 0.27, 5.4),
        Country("South Africa", 1.2, 62.0),
    )

    val size = list_of_countries.size-1

    println("Sorting by name:")
    for (i in 0..size)
    {
        for (j in i..size)
        {
            if(list_of_countries[i].name > list_of_countries[j].name)
            {
                var temp = list_of_countries[i]
                list_of_countries[i] = list_of_countries[j]
                list_of_countries[j] = temp
            }
        }
    }

    for(i in list_of_countries)
        i.Print()

    println("Sorting by area:")
    for (i in 0..size)
    {
        for (j in i..size)
        {
            if(list_of_countries[i].area > list_of_countries[j].area)
            {
                var temp = list_of_countries[i]
                list_of_countries[i] = list_of_countries[j]
                list_of_countries[j] = temp
            }
        }
    }

    for(i in list_of_countries)
        i.Print()

    val my_file = File("list.txt")
    my_file.writeText("")
    for(i in list_of_countries)
    {
        my_file.appendText(i.name+", "+i.area+", "+i.language+", "+i.population+"\n")
    }

}
