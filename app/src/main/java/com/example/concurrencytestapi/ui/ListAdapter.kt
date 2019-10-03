package com.example.concurrencytestapi.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concurrencytestapi.R
import com.example.concurrencytestapi.model.ItemModel
import com.example.concurrencytestapi.model.ProfessionalData
/**
 * @author Created by Arun
 * Adapter class to show data in list through RecyclerView.
 */
class ListAdapter(val itemModel: ItemModel) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = itemModel.data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = itemModel.data.get(position)
        holder.updateView(article)
    }
}

class ViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {

    var companyNameTv = itemVIew.findViewById<TextView>(R.id.txtCompanyName)
    var designationTv = itemVIew.findViewById<TextView>(R.id.txtDesignation)
    var durationTv = itemVIew.findViewById<TextView>(R.id.txtDuration)
    var roleTv = itemVIew.findViewById<TextView>(R.id.txtRole)
    var achievementTv = itemVIew.findViewById<TextView>(R.id.txtAchievement)

    fun updateView(article: ProfessionalData) {
        companyNameTv.text = article.companyName
        designationTv.text = article.designation

        durationTv.text = article.duration
        roleTv.text = article.role
        achievementTv.text = article.achievements
    }

}
