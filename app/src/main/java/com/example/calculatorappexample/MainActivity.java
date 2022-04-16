package com.example.calculatorappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button btn_zero, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    Button btn_c,btn_br,btn_br1, btn_div, btn_multiply, btn_add, btn_sub, btn_equalto,btn_dot,btn_AC;
    TextView inputText,output;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for text views
        inputText = findViewById(R.id.inputText);//enter data
        output = findViewById(R.id.output);//result

        // for button with operations
        btn_c = findViewById(R.id.c);
        btn_br = findViewById(R.id.bracket);
        btn_br1= findViewById(R.id.bracket1);
        btn_div= findViewById(R.id.div);
        btn_multiply = findViewById(R.id.multiply);
        btn_sub = findViewById(R.id.sub);
        btn_add = findViewById(R.id.add);
        btn_dot = findViewById(R.id.dot);
        btn_AC=findViewById(R.id.Ac);
        btn_equalto = findViewById(R.id.equallto);// for equal to button

        btn_zero= findViewById(R.id.zero);
        btn1= findViewById(R.id.one);
        btn2= findViewById(R.id.two);
        btn3 = findViewById(R.id.three);

        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);

        btn7= findViewById(R.id.seven);
        btn8= findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);







        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();

                inputText.setText(data+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"2");


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"3");


            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"4");


            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"5");


            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"6");


            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"7");


            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"8");


            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"9");


            }
        });

        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on clicking on ac button we are clearing
                // our primary and secondary text view.
                inputText.setText("");
                output.setText("");


            }
        });


        btn_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"(");


            }
        });
        btn_br1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+")");


            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+".");


            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"+");


            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"-");





            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"x");


            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputText.getText().toString();
                inputText.setText(data+"/");


            }
        });

        btn_equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =inputText.getText().toString();
//                Toast.makeText(MainActivity.this, ""+data, Toast.LENGTH_SHORT).show();
//               Log.e("@@@","onClick:"+data);

                data=data.replaceAll("x","*");
                data=data.replaceAll("/","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

                output.setText(finalResult);

            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data=inputText.getText().toString();
                data=data.substring(0,data.length()-1);
                inputText.setText(data);
                

            }
        });

    }
}