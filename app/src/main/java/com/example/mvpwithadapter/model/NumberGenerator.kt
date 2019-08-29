package com.example.mvpwithadapter.model

class NumberGenerator {


     fun getNumbers() : ArrayList<Int> {

         val list:ArrayList<Int> = arrayListOf()
         for (i in 1..50){
            list.add(i)
        }
        return list

    }


}