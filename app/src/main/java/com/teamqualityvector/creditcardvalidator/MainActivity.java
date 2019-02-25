package com.teamqualityvector.creditcardvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick();
            }
        });
    }

    public void onButtonClick()
    {
        EditText e= (EditText)findViewById(R.id.editText2);
        int[] digit=new int[11];
        if(e.getText().length()!=11)
        {
            Toast.makeText( this, "Invalid!! Card Number should have 11 digit", Toast.LENGTH_LONG).show();
            e.setText("");
        }
        else if(e.getText().equals(""))

        Toast.makeText(this,"Invalid!! Field should not be empty", Toast.LENGTH_LONG).show();
        else
        {
            for(int i=0;i<11;i++)
            {
                digit[i]=Character.getNumericValue(e.getText().charAt(i));
            }
            for(int i=0;i<11;i++)
            {
                if (i%2!=0)
                digit[i]=digit[i]*2;

                if(digit[i]>9)
                    digit[i]=digit[i]-9;
            }
        }
        int sum=0;
        for(int i=0;i<10;i++)
        {
            sum+=digit[i];
        }
        int checkDigit= (sum*9)%10;
        if (checkDigit==digit[10])
            Toast.makeText(this,"The Card Number is Valid", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"The Card Number is InValid", Toast.LENGTH_LONG).show();

    }
}
