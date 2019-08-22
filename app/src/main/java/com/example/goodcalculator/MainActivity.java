package com.example.goodcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import java.lang.Math;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bclr,bexp;
    private TextView result, info;

    private double val1;
    private double val2;
    private double res;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EXP = '^';
    private char ACTION;
    private boolean operator_seen = false;
    private boolean first_operation = true;
    private String operators = "+-*/^";
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.drawerlayout);
        b1 = (Button)findViewById(R.id.buttn1);
        b2 = (Button)findViewById(R.id.buttn2);
        b3 = (Button)findViewById(R.id.buttn3);
        b4 = (Button)findViewById(R.id.buttn4);
        b5 = (Button)findViewById(R.id.buttn5);
        b6 = (Button)findViewById(R.id.buttn6);
        b7 = (Button)findViewById(R.id.buttn7);
        b8 = (Button)findViewById(R.id.buttn8);
        b9 = (Button)findViewById(R.id.buttn9);
        b0 = (Button)findViewById(R.id.buttn0);
        badd = (Button)findViewById(R.id.buttnsum);
        bsub = (Button)findViewById(R.id.buttnsub);
        bmul = (Button)findViewById(R.id.buttnmul);
        bdiv = (Button)findViewById(R.id.buttndiv);
        bexp = (Button)findViewById(R.id.buttnexp);
        bclr = (Button)findViewById(R.id.buttnclr);
        info = (TextView)findViewById(R.id.info);
        result = (TextView)findViewById(R.id.result);
        dbHelper = new DBHelper(this);


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "0");
                compute();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "1");
                compute();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "2");
                compute();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "3");
                compute();

            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "4");
                compute();
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "5");
                compute();

            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "6");
                compute();
            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "7");
                compute();

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "8");
                compute();

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                info.setText(info.getText().toString() + "9");
                compute();

            }
        });




        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( info.getText().toString().length() == 0 )          /* Do not append operator to expression string , if the expression string is empty */
                {
                    info.setText(null);
                }
                else
                {
                    String res = info.getText().toString();
                    String last_char = String.valueOf( res.charAt( res.length()-1 ) ) ;         /* The last character in the expression already entered */

                    if ( operators.contains( last_char ) )                                      /* If the last character in the expression is already an operator, then do not insert another operator */
                    {
                        info.setText(info.getText().toString());
                    }
                    else
                    {
                        info.setText(info.getText().toString() + "+");
                        ACTION = ADDITION;
                        operator_seen = true;
                    }

                }
            }
        });


        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( info.getText().toString().length() == 0 )
                {
                    info.setText(null);
                }
                else
                {
                    String res = info.getText().toString();
                    String last_char = String.valueOf( res.charAt( res.length()-1 ) ) ;         /* The last character in the expression already entered */

                    if ( operators.contains( last_char ) )                                      /* If the last character in the expression is already an operator, then do not insert another operator */
                    {
                        info.setText(info.getText().toString());
                    }
                    else
                    {
                        info.setText(info.getText().toString() + "-");
                        ACTION = SUBTRACTION;
                        operator_seen = true;
                    }
                }
            }
        });


        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( info.getText().toString().length() == 0 )
                {
                    info.setText(null);
                }
                else
                {
                    String res = info.getText().toString();
                    String last_char = String.valueOf( res.charAt( res.length()-1 ) ) ;         /* The last character in the expression already entered */

                    if ( operators.contains( last_char ) )                                      /* If the last character in the expression is already an operator, then do not insert another operator */
                    {
                        info.setText(info.getText().toString());
                    }
                    else
                    {
                        info.setText(info.getText().toString() + "*");
                        ACTION = MULTIPLICATION;
                        operator_seen = true;
                    }
                }
            }
        });


        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( info.getText().toString().length() == 0 )
                {
                    info.setText(null);
                }
                else
                {
                    String res = info.getText().toString();
                    String last_char = String.valueOf( res.charAt( res.length()-1 ) ) ;         /* The last character in the expression already entered */

                    if ( operators.contains( last_char ) )                                      /* If the last character in the expression is already an operator, then do not insert another operator */
                    {
                        info.setText(info.getText().toString());
                    }
                    else
                    {
                        info.setText(info.getText().toString() + "/");
                        ACTION = DIVISION;
                        operator_seen = true;
                    }
                }
            }
        });

        bexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( info.getText().toString().length() == 0 )
                {
                    info.setText(null);
                }
                else
                {
                    String res = info.getText().toString();
                    String last_char = String.valueOf( res.charAt( res.length()-1 ) ) ;         /* The last character in the expression already entered */

                    if ( operators.contains( last_char ) )                                      /* If the last character in the expression is already an operator, then do not insert another operator */
                    {
                        info.setText(info.getText().toString());
                    }
                    else
                    {
                        info.setText(info.getText().toString() + "^");
                        ACTION = EXP;
                        operator_seen = true;
                    }
                }
            }
        });


        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String expression = info.getText().toString();
                String res = result.getText().toString();

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String timestamp = formatter.format(date);

                boolean ret = dbHelper.add_op( timestamp , expression , res );

                if ( ret )
                {
                    Toast.makeText(MainActivity.this , "Operation added successfully" , Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this , "Operation could not be added" , Toast.LENGTH_SHORT ).show();
                }

                info.setText(null);
                result.setText(null);
                operator_seen = false;
                first_operation = true;

            }
        });






        /* Logic for the navigation menu */


        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.NavBar);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if ( id == R.id.history )
                {
                    //Toast.makeText(MainActivity.this,"Operation History" , Toast.LENGTH_SHORT ).show();

                    Intent i = new Intent( MainActivity.this , OperationActivity.class );
                    startActivity(i);
                }


                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    private void compute()
    {
        if ( operator_seen )            /* If an operator has been typed atleast once implies two operands are available, then compute() method will return a result */
        {
            String expression = info.getText().toString();
            int index_of_op = expression.lastIndexOf(ACTION);                                           /* Find the last index of the operator in the expression */

            //System.out.println(expression);

            if( first_operation )
            {
                val1 = Double.parseDouble( expression.substring( 0 ,  index_of_op ) );               /* Fetching first operand */
                val2 = Double.parseDouble( expression.substring( index_of_op+1 ) );
                first_operation = false;
            }
            else
            {
                val1 = Double.parseDouble( result.getText().toString() );                           /* Fetch the first operand from the result */
                val2 = Double.parseDouble( expression.substring( index_of_op+1 ) );
            }

            switch(ACTION)
            {

                case ADDITION :       res = val1 + val2;
                                      break;

                case SUBTRACTION :    res = val1 - val2;
                                      break;

                case MULTIPLICATION : res = val1 * val2;
                                      break;

                    case DIVISION :  if( val2 != 0 )
                                     {
                                        res = val1 / val2;
                                     }
                                     else
                                     {
                                        Toast.makeText(MainActivity.this,"Can't divide by zero" , Toast.LENGTH_SHORT).show();
                                     }

                                     break;

                case EXP :          res = Math.pow( val1 , val2 );
                                    break;

            }

            result.setText(String.valueOf(res));                                                    /* Display the result in the text box for result */

        }

    }







}
