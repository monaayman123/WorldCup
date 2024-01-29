package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManager{
    private  val matchList= mutableListOf<Match>()
    private var matchIndex=1
    fun addmatch(match: Match){
        matchList.add(match)
    }
    fun getCurrentMatch():Match= matchList[matchIndex]
    fun getNextMatch():Match{
        matchIndex++
        if (matchIndex== matchList.size){
            matchIndex=1
        }
        return matchList[matchIndex]
    }
    fun getPreviousMatch():Match{
        matchIndex--
        if (matchIndex==-1){
            matchIndex= matchList.size-1
        }
        return matchList[matchIndex]
    }
}
