package com.ratmux.animeflix

class SiteAdapter(private val siteListesi: List<SiteLogosu>) :
    RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // inner ekle
        val logo: ImageView = itemView.findViewById(R.id.site_logo)
        val isim: TextView = itemView.findViewById(R.id.site_ismi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_site, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val site = siteListesi[position]
        holder.logo.setImageResource(site.logoResId)
        holder.isim.text = site.siteAdi
    }

    override fun getItemCount(): Int {
        return siteListesi.size // return ekle
    }
}