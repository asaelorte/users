package com.example.users.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.User
import com.example.users.R
import com.example.users.databinding.UserAdapterBinding
import com.example.users.ui.common.loadUrl


class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = users[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserHolder(layoutInflater.inflate(R.layout.user_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = UserAdapterBinding.bind(itemView)
        fun bind(user: User) {
            binding.image.loadUrl(user.picture.large)
            val nameFull = user.name.title + " " + user.name.first + " " + user.name.last
            binding.name.text = nameFull
            binding.email.text = user.email
            binding.phone.text = user.phone
            binding.number.text = user.location.street.number.toString()
            binding.name.text = user.location.street.name
            binding.city.text = user.location.city
            binding.states.text = user.location.state
            binding.country.text = user.location.country
            binding.postcode.text = user.location.postcode
        }
    }
}