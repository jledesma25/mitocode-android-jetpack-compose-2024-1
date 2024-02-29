package com.mitocode.mitocodecoursecompose2024_i.examples.basic_kotlin

fun main(){

    println("Inicio de funcion")

    //Variables Mutables
    var name:String = "Juan José"
    name = "Juan José Ledesma"

    //Variables Immutables
    val price = 30

    //Listas immutables
    val daysOfWeek = listOf("Lunes","Martes","Miercoles","Jueves",
        "Viernes","Sabado","Domingo")

    println(daysOfWeek[0])
    println(daysOfWeek.first())
    println(daysOfWeek.last())
    println(daysOfWeek.size)

    for(day in daysOfWeek){
        println(day)
    }
    daysOfWeek.forEach { day ->
        println("El día de la semana es $day")
    }

    val ratings = listOf(18.0, 12.5, 15.2, 20.0, 10.0)

    // name:(Tipo de valor que te va a exponer)->El tipo de valor de retorno
    val ratingsFilter = ratings.filter {
        it >= 13
    }

    println(ratingsFilter)

    //Listas mutables
    val persons : MutableList<String> = mutableListOf("Juan José")
    persons.add("Diego")

    //PROGRAMACION ORIENTADA A OBJETOS : POO
    //CLASES : ESTRUCTURAS

    val juanjose = Person("Juan José",34)
    println(juanjose.name)
    println(juanjose.age)

    val otherPerson = juanjose.copy(age = 35)

    val (name2,age2) = Person("Diego",28)

    val steve = Person()

    //NULLSAFETY : Seguridad ante nulos
    var word : String? = "Mitocode" //8
    getString(word!!) //String? -> String

    //NULL: Ausencia de valor, algo que no esta definido
    //En Kotlin, nada puede ser por default nulo
    //Protejerla/NULLSAFETY ?
    word = null

    //Simbolo Elvis  ?:

    val result = word?.length ?: "0"
    println(result)
}

fun getString(word:String){

}