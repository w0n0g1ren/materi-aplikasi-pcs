package com.pcs.apptoko.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pcs.apptoko.R
import com.pcs.apptoko.response.transaksi.Transaksi
import java.text.NumberFormat
import java.util.Locale

class LaporanAdapter (val ListTransaksi :
List<Transaksi>):RecyclerView.Adapter<LaporanAdapter.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTglTransaksi = itemView.findViewById(R.id.txtTransaksi) as TextView
        val txtNoNota = itemView.findViewById(R.id.txtNoNota) as TextView
        val txtItemTotalTrans = itemView.findViewById(R.id.txtItemTotalTrans) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan,parent,false)
        return LaporanAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaporanAdapter, position: Int) {
        val transaksi = listTransaksi[position]
        holder.txtTglTransaksi.text = transaksi.tanggal
        holder.txtNoNota.text = "#0000"+transaksi.id

        val localID = Locale("in","ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localID)

        holder.txtitemTotalTrans.text = numberFormat.format(transaksi.total.toDouble()).toString()
    }

    override fun getItemCount(): Int {
        return listTransaksi.size
    }
}