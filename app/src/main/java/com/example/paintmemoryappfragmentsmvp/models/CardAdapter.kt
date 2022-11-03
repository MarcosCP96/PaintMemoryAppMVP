package com.example.paintmemoryappfragmentsmvp.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.paintmemoryappfragmentsmvp.R

class CardAdapter(private var listOfCards: List<Card>,
                  private var onClick: (card: Card) -> Unit):
    RecyclerView.Adapter<CardAdapter.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_game_recycler, parent, false)
        return CardHolder(view)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val item = listOfCards[position]
        holder.firstCard.setImageResource(item.cardBack)
        item.imageView = holder.firstCard
        holder.firstCard.setOnClickListener {
            onClick.invoke(item)
        }
    }

    override fun getItemCount(): Int = listOfCards.size

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        var firstCard: ImageView = view.findViewById(R.id.gameCard)
    }
}
