package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button;
import android.widget.*;




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag:String ="Normal"
        val spinnerVal: Spinner=findViewById(R.id.spSelect)
        var options = arrayOf("Normal","Premium")
        var result: Double = 1.0;
        val spinnerCa: Spinner=findViewById(R.id.spCash)
        var flag2:String ="Visa"
        var option2 = arrayOf("Visa","Cash")


        spinnerVal.adapter = ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,options)

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spinnerCa.adapter= ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,option2)

        spinnerCa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag2 = option2.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }



            button.setOnClickListener {  view ->
            var seats:Double = edtxt1.text.toString().toDouble()
            var days:Double = edtxt2.text.toString().toDouble()

                if (flag=="Premium") {

                    if(flag2=="Visa"){
                        result = Visa(Pflight(seats, days))}
                    else result = Pflight(seats, days)

                    resultTV.text = result.toString()


                } else
                    if(flag=="Normal") {

                        if(flag2=="Visa"){
                            result = Visa(Nflight(seats, days))}
                        else result = Nflight(seats, days)


                        resultTV.text = result.toString()

                    }
        }
    }
}

    public fun Pflight( a: Double, b: Double) : Double{

        var days = b*6
    return (a*450)+days;
    }

    public fun Nflight(a: Double, b:Double ):Double {
        var days = b*5
    return return (a*300)+days;
    }

    public fun Visa(a:Double) :Double{

        return a*1.05
    }