package com.example.myapplication.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.TodoViewModel
import com.example.myapplication.adapter.TodoAdapter

class TodoFragment : Fragment() {
    private lateinit var viewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todolist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("TodoFragment loaded")
        val recyclerView = view.findViewById<RecyclerView>(R.id.todo_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        viewModel.todoLiveData.observe(viewLifecycleOwner) { todos ->
            recyclerView.adapter = TodoAdapter(todos)
        }


    }
}
