package com.example.apphospital.Fragments.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.R
import kotlinx.android.synthetic.main.item1_registrodiario_estado_de_animo.*


private const val position = 0


class Item1Fragment(val retriever: Retriever) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.item1_registrodiario_estado_de_animo, container, false)
        val group = v.findViewById(R.id.radioGroup) as RadioGroup
        val answer = Bundle()

        val selected = group.getCheckedRadioButtonId()
        val selectedID = resources.getResourceEntryName(selected)


        when (selectedID){
            "radio_1_Animo" -> {
                answer.putInt("animo", 0)
                retriever.retrieve(answer, position)
            }

            "radio_2_Animo" -> {
                answer.putInt("animo", 1)
                retriever.retrieve(answer, position)
            }

            "radio_3_Animo" -> {
                answer.putInt("animo", 2)
                retriever.retrieve(answer, position)
            }

            "radio_4_Animo" -> {
                answer.putInt("animo", 3)
                retriever.retrieve(answer, position)
            }

            "radio_5_Animo" -> {
                answer.putInt("animo", 4)
                retriever.retrieve(answer, position)
            }

            "radio_6_Animo" -> {
                answer.putInt("animo", 5)
                retriever.retrieve(answer, position)
            }

            "radio_7_Animo" -> {
                answer.putInt("animo", 6)
                retriever.retrieve(answer, position)
            }

            "radio_8_Animo" -> {
                answer.putInt("animo", 7)
                retriever.retrieve(answer, position)
            }

            "radio_9_Animo" -> {
                answer.putInt("animo", 8)
                retriever.retrieve(answer, position)
            }

            "radio_10_Animo" -> {
                answer.putInt("animo", 9)
                retriever.retrieve(answer, position)
            }

        }


        return v
    }

}
