package com.example.lab7recyclerviewdialog2022

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab7recyclerviewdialog2022.databinding.EmpItemLayoutBinding
import com.example.lab7recyclerviewdialog2022.databinding.StdItemLayoutBinding
import layout.Student
import layout.StudentsAdapter

class EmployeeAdapter (val employeeList: ArrayList<Employee>?, val context: Context):
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>(){

    class ViewHolder(view: View, val binding: EmpItemLayoutBinding):
        RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.ViewHolder {
        val binding = EmpItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeAdapter.ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtName.text = "Name: ${employeeList!![position].name}"
        binding.txtGender.text = "Gender: ${employeeList!![position].gender}"
        binding.txtEmail.text = "Email: ${employeeList!![position].email}"
        binding.txtSalary.text = "Salary: ${employeeList!![position].salary}"
    }

    override fun getItemCount(): Int {
        return employeeList!!.size
    }

}