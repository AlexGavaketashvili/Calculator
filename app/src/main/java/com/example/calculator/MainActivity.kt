package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonclear.setOnClickListener {
            input.text = ""
            result.text = ""
        }
        buttonleftbracket.setOnClickListener {
            input.text = addinputtext("(")
        }
        buttonrightbracket.setOnClickListener {
            input.text = addinputtext(")")
        }
        buttongayopa.setOnClickListener {
            input.text = addinputtext("÷")
        }
        buttongamravleba.setOnClickListener {
            input.text = addinputtext("*")
        }
        buttongamokleba.setOnClickListener {
            input.text = addinputtext("-")
        }
        buttonmimateba.setOnClickListener {
            input.text = addinputtext("+")
        }
        button0.setOnClickListener {
            input.text = addinputtext("0")
        }
        button1.setOnClickListener {
            input.text = addinputtext("1")
        }
        button2.setOnClickListener {
            input.text = addinputtext("2")
        }
        button3.setOnClickListener {
            input.text = addinputtext("3")
        }
        button4.setOnClickListener {
            input.text = addinputtext("4")
        }
        button5.setOnClickListener {
            input.text = addinputtext("5")
        }
        button6.setOnClickListener {
            input.text = addinputtext("6")
        }
        button7.setOnClickListener {
            input.text = addinputtext("7")
        }
        button8.setOnClickListener {
            input.text = addinputtext("8")
        }
        button9.setOnClickListener {
            input.text = addinputtext("9")
        }
        buttonwertili.setOnClickListener {
            input.text = addinputtext(".")
        }
        buttonequals.setOnClickListener {
            showresults()
        }
        buttonwashla.setOnClickListener {
            deleteinput()
        }

    }

    private fun deleteinput() {
        val lenght = input.text.length
        if (lenght > 0) {
            input.text = input.text.subSequence(0, lenght - 1)
        }
    }

    private fun showresults() {
        try {
            val expression = getinputexpression()
            val resultt = Expression(expression).calculate()
            if (resultt.isNaN()) {
                //
            }else {
                result.text = DecimalFormat("0.#####").format(resultt).toString()
                result.setTextColor(ContextCompat.getColor(this, R.color.green))
            }

        } catch (e:Exception) {

        }
    }

    fun addinputtext(buttonvalue: String): String {
        return "${input.text}$buttonvalue"
    }

    private fun getinputexpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("x"), "*")
        return expression
    }

}
