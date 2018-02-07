package com.example.user.android_assignment_11_2;
//Package objects contain version information about the implementation and specification of a Java package.
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    AutoCompleteTextView autoCompleteTextView;
    //An editable text view that shows completion suggestions automatically while the user is typing
    TextView textView;
    //A user interface element that displays text to the user.
    ArrayList<String> productname;
//ArrayList is a part of collection framework and It provides us dynamic arrays in Java.

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        textView=(TextView)findViewById(R.id.textView);
        //created an object and instantiated it
        productname=new ArrayList<>();
        //creating new array list
        productname.add("Hp Inkjet Printer");
        //adding the values to the array list
        productname.add("Hyderabad");
        productname.add("Astron Martin");
        MyHelper myHelper=new MyHelper(this);
        //create the database object
        //this database helper will help us to maintain the database and helper will take the values from the main activity
        for(int i=0;i<productname.size();i++)
        {
            myHelper.Addproducts(productname.get(i));//here we will get the products and add to the database
        }
        ArrayList arrayList=myHelper.Databasetoarray();
        //creating an arraylist object and converting the database to array using myhelper
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        //created an objects
        //Finds a view that was identified by the android:id XML attribute that was processed in onCreate(Bundle).
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        autoCompleteTextView.setThreshold(1);
        //Specifies the minimum number of characters the user has to type in the edit box before the drop down list is shown.
        //When threshold is less than or equals 0, a threshold of 1 is applied.
        autoCompleteTextView.setAdapter(arrayAdapter);
        //Sets the adapter that provides the data and the views to represent the data in this widget
    }

}
