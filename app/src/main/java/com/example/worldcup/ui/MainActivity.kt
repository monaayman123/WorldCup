package com.example.worldcup.ui


import android.view.LayoutInflater
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.domain.Match

import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CsvParse
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.log

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String="MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate


         override fun setUp(){
         parseFile()

      }
         override fun addCallBack() {
        binding.apply {
            iconNext.setOnClickListener {
                DataManager.getNextMatch()
               bindMatch(DataManager.getCurrentMatch())
            }
            iconPrevious.setOnClickListener {
                DataManager.getPreviousMatch()
                bindMatch(DataManager.getPreviousMatch())
            }
        }
        }

         private fun parseFile(){
        val inputstream=  assets.open("worldcup.csv")
        val buffer=BufferedReader(InputStreamReader(inputstream))
        val parsser=CsvParse()
        buffer.forEachLine {
        log(it)
            val currentmatch=parsser.parse(it)
            DataManager.addmatch(currentmatch)
        }
             bindMatch(DataManager.getCurrentMatch())
    }
  private fun bindMatch(match: Match) {
   binding.apply {
    textYear.text=match.year
    textCity.text=match.stadium
    textTeam1.text=match.homeTeamName
    textTeam2.text=match.awayTeamName
    textTeam1Score.text=match.homeTeamGoals
    textTeam2Score.text=match.awayTeamGoals
}

}
}