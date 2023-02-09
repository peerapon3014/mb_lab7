package com.example.lab7recyclerviewdialog2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab7recyclerviewdialog2022.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import layout.Student
import layout.StudentsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var employeeList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentData()

        binding.recyclerView.adapter = StudentsAdapter(this.studentList, applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(itemDecor)

        binding.btnAddEmployee.setOnClickListener{
            val mDialogView = LayoutInflater.from(
                this).inflate(R.layout.add_dialog_layout, null)
            val myBuilder = AlertDialog.Builder(this)
            myBuilder.setView(mDialogView)
            myBuilder.setPositiveButton("Add Employee"){dialog, which ->
                val name = mDialogView.findViewById(R.id.edtName) as TextInputEditText
                val gender = mDialogView.findViewById(R.id.edtGender) as TextInputEditText
                val email = mDialogView.findViewById(R.id.edtEmail) as TextInputEditText
                val salary = mDialogView.findViewById(R.id.edtSalary) as TextInputEditText
                employeeList.add(
                    Employee(name.text.toString(),gender.text.toString(),email.text.toString(),salary.text.toString().toInt()))

                binding.recyclerView.adapter?.notifyDataSetChanged()
                Toast.makeText(
                    applicationContext,
                    "The Employee is added Succesfully",
                    Toast.LENGTH_LONG
                ).show()
            }
            myBuilder.setNegativeButton("Cancel"){dialog,which ->
                dialog.dismiss()
            }
            myBuilder.show()        }
    }
    fun  studentData() {
        employeeList.add(Employee("Peera","male","Peera@pee.com", salary = 10000))
        employeeList.add(Employee("Peea","female","Peea@pee.com", salary = 10000))
        employeeList.add(Employee("Peerapon","male","Peerapon@pee.com", salary = 10000))
    }

}