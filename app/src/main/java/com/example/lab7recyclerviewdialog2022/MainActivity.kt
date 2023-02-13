package com.example.lab7recyclerviewdialog2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab7recyclerviewdialog2022.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import layout.Student
import layout.StudentsAdapter
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var employeeList = arrayListOf<Employee>()
    var gender:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentData()

        binding.recyclerView.adapter = EmployeeAdapter(this.employeeList, applicationContext)
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
                val email = mDialogView.findViewById(R.id.edtEmail) as TextInputEditText
                val salary = mDialogView.findViewById(R.id.edtSalary) as TextInputEditText
                var radioGroup: RadioGroup = mDialogView.findViewById(R.id.radioGender) as RadioGroup

                var radioButtonChecked: RadioButton = mDialogView.findViewById(radioGroup.checkedRadioButtonId) as RadioButton
                gender  = radioButtonChecked.text as String

                if (name?.text.toString().isEmpty() && name?.text.toString()
                        .isEmpty() && salary?.text.toString().isEmpty()
                ) {
                    Toast.makeText(applicationContext, "err no data", Toast.LENGTH_LONG).show()
                } else {
                    employeeList.add(
                        Employee(
                            name.text.toString(),
                            gender,
                            email.text.toString(),
                            salary.text.toString().toInt()
                        )
                    )

                    binding.recyclerView.adapter?.notifyDataSetChanged()
                    Toast.makeText(
                        applicationContext,
                        "The Student is added successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            myBuilder.setNegativeButton("Cancel"){dialog,which ->
                dialog.dismiss()
            }
            myBuilder.show()        }
    }
    fun  studentData() {
        employeeList.add(Employee("Peera","Male","Peera@pee.com", salary = 10000))
        employeeList.add(Employee("Peea","Female","Peea@pee.com", salary = 10000))
        employeeList.add(Employee("Peerapon","Male","Peerapon@pee.com", salary = 10000))
    }

}