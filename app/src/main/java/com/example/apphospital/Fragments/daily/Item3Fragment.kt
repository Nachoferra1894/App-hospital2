package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R

private const val position = 2


class Item3Fragment(val retriever: Retriever) : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):View ?{
        val v = inflater.inflate(R.layout.item3_registrodiario_apetito, container, false)
        val group = v.findViewById(R.id.radioGroup) as RadioGroup
        val answer = Bundle()

        val selected = group.getCheckedRadioButtonId()
        val selectedID = resources.getResourceEntryName(selected)


        when (selectedID){
            "radio_1_apetito" -> {
                answer.putInt("apetito", 0)
                retriever.retrieve(answer, position)
            }

            "radio_2_apetito" -> {
                answer.putInt("apetito", 1)
                retriever.retrieve(answer, position)
            }

            "radio_3_apetito" -> {
                answer.putInt("apetito", 2)
                retriever.retrieve(answer, position)
            }

            "radio_4_apetito" -> {
                answer.putInt("apetito", 3)
                retriever.retrieve(answer, position)
            }

            "radio_5_apetito" -> {
                answer.putInt("apetito", 4)
                retriever.retrieve(answer, position)
            }

            "radio_6_apetito" -> {
                answer.putInt("apetito", 5)
                retriever.retrieve(answer, position)
            }

            "radio_7_apetito" -> {
                answer.putInt("apetito", 6)
                retriever.retrieve(answer, position)
            }

            "radio_8_apetito" -> {
                answer.putInt("apetito", 7)
                retriever.retrieve(answer, position)
            }

            "radio_9_apetito" -> {
                answer.putInt("apetito", 8)
                retriever.retrieve(answer, position)
            }

            "radio_10_apetito" -> {
                answer.putInt("apetito", 9)
                retriever.retrieve(answer, position)
            }

        }

        return v
    }
}