package dev.ghani.learnanimalname

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimals.add(Animal("Baboon", "Ini adalah Baboon",R.drawable.baboon))
        listOfAnimals.add(Animal("Buldlog", "Ini adalah Anjing Bulldog",R.drawable.bulldog))
        listOfAnimals.add(Animal("Panda", "Ini adalah Panda",R.drawable.panda))
        listOfAnimals.add(Animal("Swallow Bird", "Ini adalah Burung Swallow",R.drawable.swallow_bird))
        listOfAnimals.add(Animal("White Tiger", "Ini adalah Macan Putih",R.drawable.white_tiger))
        listOfAnimals.add(Animal("Zebra", "Ini adalah Kuda Zebra",R.drawable.zebra))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context: Context?=null

        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals=listOfAnimals
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket,null)
            myView.tvName.text = animal.name!!
            myView.tvDes.text = animal.des!!
            myView.ivAnimalImage.setImageResource(animal.image!!)

            return myView
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
