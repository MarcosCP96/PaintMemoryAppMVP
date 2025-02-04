package com.example.paintmemoryappfragmentsmvp.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.paintmemoryappfragmentsmvp.R

class CardAdapter(private var onClick: (card: CardNew) -> Unit):
                    RecyclerView.Adapter<CardAdapter.CardHolder>() {

    private val listOfCards: MutableList<CardNew> = mutableListOf()

    fun updateCards(cards: List<CardNew>){
        this.listOfCards.clear()
        this.listOfCards.addAll(cards)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_game_recycler, parent, false)
        return CardHolder(view)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val item = listOfCards[position]
        if (!item.isTurned){
            holder.firstCard.setImageResource(R.drawable.app_icon_small)
        } else {
            holder.firstCard.setImageResource(item.image)
        }
        holder.firstCard.setOnClickListener {
            if (item.isEnabled){
                onClick.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int = listOfCards.size

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        var firstCard: ImageView = view.findViewById(R.id.gameCard)
    }
}