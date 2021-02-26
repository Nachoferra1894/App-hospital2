package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R

private const val position = 1


class Item2Fragment(val retriever: Retriever) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):View ?{
            val v = inflater.inflate(R.layout.item2_registrodiario_dolor, container, false)
            val group = v.findViewById(R.id.radioGroup) as RadioGroup
            val answer = Bundle()

            val selected = group.getCheckedRadioButtonId()
            val selectedID = resources.getResourceEntryName(selected)


            when (selectedID){
                "radio_1_dolor" -> {
                    answer.putInt("dolor", 0)
                    retriever.retrieve(answer, position)
                }

                "radio_2_dolor" -> {
                    answer.putInt("dolor", 1)
                    retriever.retrieve(answer, position)
                }

                "radio_3_dolor" -> {
                    answer.putInt("dolor", 2)
                    retriever.retrieve(answer, position)
                }

                "radio_4_dolor" -> {
                    answer.putInt("dolor", 3)
                    retriever.retrieve(answer, position)
                }

                "radio_5_dolor" -> {
                    answer.putInt("dolor", 4)
                    retriever.retrieve(answer, position)
                }

                "radio_6_dolor" -> {
                    answer.putInt("dolor", 5)
                    retriever.retrieve(answer, position)
                }

                "radio_7_dolor" -> {
                    answer.putInt("dolor", 6)
                    retriever.retrieve(answer, position)
                }

                "radio_8_dolor" -> {
                    answer.putInt("dolor", 7)
                    retriever.retrieve(answer, position)
                }

                "radio_9_dolor" -> {
                    answer.putInt("dolor", 8)
                    retriever.retrieve(answer, position)
                }

                "radio_10_dolor" -> {
                    answer.putInt("apetito", 9)
                    retriever.retrieve(answer, position)
                }

            }

            return v
    }
}