package com.example.apphospital

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.apphospital.Fragments.register.*
import com.example.apphospital.Fragments.registerUtilities.Retriever
import com.example.apphospital.classes.DatPagerAdapter
import com.example.apphospital.classes.DiabeticClass
import com.example.apphospital.classes.SmokeClass
import com.example.apphospital.classes.UserClass
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register_details_form.*


private const val NUM_PAGES = 5

class RegisterDetailsForm() : FragmentActivity(),Retriever {

    private lateinit var viewPager: ViewPager2

    var smokes = 0
    var cant = 0
    var time = 0
    var diabetic = false
    var med :String? = null
    var hip=false
    var epoc=false
    var acv = false
    var inf = false
    lateinit var nombre:String
    lateinit var email:String
    var genero = false
    lateinit var  date:String
    lateinit var dni:String
    lateinit var medic:String
    lateinit var place:String
    lateinit var etnia:String
    lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_details_form)
        nombre = intent.getStringExtra("nombre")
        email = intent.getStringExtra("email")
        genero = intent.getBooleanExtra("genero", true)
        date =intent.getStringExtra("date")
        dni = intent.getStringExtra("dni")
        medic = intent.getStringExtra("medic")
        place = intent.getStringExtra("place")
        etnia = intent.getStringExtra("etnia")
        id = intent.getStringExtra("id")

        viewPager = findViewById<ViewPager2>(R.id.regform_slideview_fragments)

        val adapter = DatPagerAdapter(this)
        var fragsList = listOf(SmokerFragment(this), SmokerDetailFragment(this), DiabetesFragment(this), DiabetedMed(this), Extras(this))
        initializeFrags(viewPager, adapter, fragsList, 0)

        addDots(0, fragsList.size)

        val pageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addDots(position, fragsList.size)
            }
        }

        viewPager.registerOnPageChangeCallback(pageChangeCallBack)
    }

    private fun initializeFrags(pager: ViewPager2, adapter: DatPagerAdapter, fragsList: List<Fragment>, current: Int){
        adapter.fragsListHere.addAll(fragsList)
        viewPager.adapter = adapter
        viewPager.currentItem = current
    }

    @SuppressLint("ResourceAsColor")
    private fun addDots(position: Int, size: Int) {

        val mDots = Array(size) { TextView(this) }
        regform_ll_mdot.removeAllViews()

        for (text in mDots){
            text.text = Html.fromHtml("&#8226")
            text.textSize = 35F
            text.setTextColor(resources.getColor(R.color.azul_registro))

            regform_ll_mdot.addView(text)
        }

        if(mDots.isNotEmpty()){
            mDots[position].setTextColor(resources.getColor(R.color.orange))
        }
    }

    private fun endActivity(){

        loadingPanelRegister.visibility = View.VISIBLE
        loadingPanelRegister.bringToFront()

        val smokerC = SmokeClass(smokes.toString(), cant.toString(), time.toString())
        val diabeticC = DiabeticClass(diabetic, med)

        val user:UserClass
        if(genero){
            user = UserClass(nombre, dni, genero, date, medic, place, etnia, id, smokerC, diabeticC, hip, epoc, acv, inf, null, "10")
        }
        else{
            user = UserClass(nombre, dni, genero, date, medic, place, etnia, id, smokerC, diabeticC, hip, epoc, acv, inf, null, "1")
        }

        //TODO load user into base

        val db = FirebaseFirestore.getInstance()


        val userPlace = db.collection("users").document(id)
        userPlace.get()
                .addOnSuccessListener { document ->
            if (!document.exists()) {
                userPlace.set(user)
                ReadWriteUserData.write(user, this)
                loadingPanelRegister.visibility = View.INVISIBLE
                val text = "Usuario registrado exitosamente"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                startActivity(Intent(this, Home::class.java))
                finish()
            } else {
                loadingPanelRegister.visibility = View.INVISIBLE
                val text = "Usuario ya existe"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
                .addOnFailureListener { exception ->
                    loadingPanelRegister.visibility = View.INVISIBLE
                    val text = "A ocurrido un error"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                }
    }

    override fun retrieve(message: Bundle, position: Int) {
        when(position){
            0 -> {
                when (message.getInt("smk")) {
                    0 -> {
                        smokes = 0
                        viewPager.currentItem = position + 2
                    }
                    1 -> {
                        smokes = 1
                        viewPager.currentItem = position + 1
                    }
                    2 -> {
                        smokes = 2
                        viewPager.currentItem = position + 1
                    }
                }
            }
            1 -> {
                cant = message.getInt("cant")
                time = message.getInt("time")
                viewPager.currentItem = position + 1
            }
            2 -> {
                val bool = message.getBoolean("db")
                if (bool) {
                    diabetic = bool
                    viewPager.currentItem = position + 1
                } else {
                    diabetic = bool
                    viewPager.currentItem = position + 2
                }
            }
            3 -> {
                med = message.getString("med")
                viewPager.currentItem = position + 1
            }
            4 -> {
                hip = message.getBoolean("hip")
                epoc = message.getBoolean("epoc")
                acv = message.getBoolean("acv")
                inf = message.getBoolean("inf")

                if ((smokes != 0 && cant == 0) || (smokes != 0 && time == 0) || (diabetic && med == null)) {
                    val text = "Completa todos los datos antes de seguir"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                } else {
                    endActivity()
                }
            }
        }
    }

}