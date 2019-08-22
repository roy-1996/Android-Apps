package com.example.goodcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import android.database.Cursor;
import android.widget.Toast;

public class OperationActivity extends AppCompatActivity {

    ListView listView;
    Cursor res;
    DBHelper dbHelper;
    ArrayList<OperationClass> op_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        /* Database query to retreive the list of operations from the database */

        dbHelper = new DBHelper(this);
        op_list = new ArrayList<OperationClass>();


        res = dbHelper.get_ops();

        System.out.print("Res" + res.getCount());

        /* If there are operations in the database, then create the Operation class objects and append them to the ArrayList */

        if( res.getCount() > 0 )
        {
            while (res.moveToNext()) {
                OperationClass op_obj = new OperationClass();
                op_obj.setTimestamp(res.getString(0));
                op_obj.setExpression(res.getString(1));
                op_obj.setResult(res.getString(2));
                op_list.add(op_obj);
            }
        }
        else
        {
            Toast.makeText( getApplicationContext() , "Operation History is empty" , Toast.LENGTH_SHORT ).show();
        }



        listView = (ListView)findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter( getApplicationContext() , op_list );
        listView.setAdapter( customAdapter );

    }
}
