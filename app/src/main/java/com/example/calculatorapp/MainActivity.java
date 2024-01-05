package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1,number2;
    TextView res;
    char op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1=findViewById(R.id.num1);
        number2=findViewById(R.id.num2);
        res=findViewById(R.id.res);
    }

    public void numbers(View v)
    {
        Button b=(Button) v;
        String s=(String)b.getText();
        if(number1.hasFocus())
            number1.append(s);
        else if(number2.hasFocus())
            number2.append(s);
        else

            Toast.makeText(this,"Please get the focus on number1/number2 field",Toast.LENGTH_LONG).show();

    }

    public void add(View v)
    {
        op='+';
    }

    public void subtract(View v)
    {
        op='-';
    }
    public void multiply(View v)
    {
        op='*';
    }
    public void divide(View v)
    {
        op='/';
    }

    public void compute(View v)
    {
        float n1,n2,r;
        switch(op)
        {
            case '+': n1=Float.parseFloat(number1.getText().toString());
                n2=Float.parseFloat(number2.getText().toString());
                r=n1+n2;
                res.setText(""+n1+"+"+n2+"="+r);
                break;
            case '-': n1=Float.parseFloat(number1.getText().toString());
                n2=Float.parseFloat(number2.getText().toString());
                r=n1-n2;
                res.setText(""+n1+"-"+n2+"="+r);
                break;
            case '*': n1=Float.parseFloat(number1.getText().toString());
                n2=Float.parseFloat(number2.getText().toString());
                r=n1*n2;
                res.setText(""+n1+"*"+n2+"="+r);
                break;
            case '/': n1=Float.parseFloat(number1.getText().toString());
                n2=Float.parseFloat(number2.getText().toString());
                r=n1/n2;
                res.setText(""+n1+"/"+n2+"="+r);
                break;
            default:break;

        }
    }

    public void all_clear(View v)
    {
        number1.setText("");
        number2.setText("");
        res.setText("");
    }

    public void clear_field_completely(View v)
    {
        if(number1.hasFocus())
        {
            number1.setText("");
            res.setText("");
        }
        else if(number2.hasFocus())
        {
            number2.setText("");
            res.setText("");
        }
        else
            Toast.makeText(this, "Please get the focus on number1/number2 field", Toast.LENGTH_LONG).show();
    }

    public void clear_one_digit_at_a_time(View v)
    {
        if(number1.hasFocus())
        {
            String n;
            n=number1.getText().toString();
            n=n.substring(0,n.length()-1);
            number1.setText(n);
        }
        else if(number2.hasFocus())
        {
            String n;
            n=number2.getText().toString();
            n=n.substring(0,n.length()-1);
            number2.setText(n);
        }
        else
            Toast.makeText(this, "Please get the focus on number1/number2 field", Toast.LENGTH_LONG).show();
    }
}
