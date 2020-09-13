package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGood extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Extra data
    public static final String EXTRA_ID = "com.example.inventory.extraid";
    public static final String EXTRA_TYPE = "com.example.inventory.type";
    public static final String EXTRA_NAME = "com.example.inventory.name";
    public static final String EXTRA_QUANTITY = "com.example.inventory.quantity";
    public static final String EXTRA_PRICE = "com.example.inventory.price";

    private Boolean editMode;
    private int updatedId;
    //Defining a spinner
    Spinner spinner;
    //Defining edit texts

    EditText name, quantity, goodPrice;

    //Defining button

    Button insertButton;

    //Strings for holding values
    String spinnerValue;

    //New AddGoodViewModel
    private AddGoodViewModel addGoodViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_good);

        //declaring edit texts
        name = (EditText)findViewById(R.id.good_name);
        quantity = (EditText)findViewById(R.id.good_quantity);
       // goodCost = (EditText)findViewById(R.id.good_cost);
        goodPrice = (EditText)findViewById(R.id.good_price);


        //declaring button
        insertButton = (Button)findViewById(R.id.insert_button);

        //Declaring a spinner
        spinner = (Spinner)findViewById(R.id.good_type);

        //AddGoodViewModel initializing;
        addGoodViewModel = ViewModelProviders.of(this,new MyAddGoodViewModelFactory(this.getApplication())).get(AddGoodViewModel.class);


        //Initiating the spinner=========================================================================================================

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.shop_contents_for_inserting,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

       //check if insert or update data

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID))
        {
            //Update data
            setTitle(getString(R.string.update_data));
            editMode = true;
            updatedId = intent.getIntExtra(EXTRA_ID,-1);
            name.setText(intent.getStringExtra(EXTRA_NAME));
            quantity.setText(intent.getStringExtra(EXTRA_QUANTITY));
            goodPrice.setText(intent.getStringExtra(EXTRA_PRICE));
            String setSpinnerType = intent.getStringExtra(EXTRA_TYPE);
            if(setSpinnerType.equals("اكسسوار"))
                spinner.setSelection(1);
            else if(setSpinnerType.equals("كوتش"))
                spinner.setSelection(2);
            else if(setSpinnerType.equals("زيت"))
                spinner.setSelection(3);
            else if(setSpinnerType.equals("قطع غيار"))
                spinner.setSelection(4);
        }
        else
        {
            //Insert data
            setTitle(getString(R.string.insert_data));
            editMode = false;

        }




        //Set onClickListener for the button =========================================================================================================

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });

        //Set onClickListener for the button =========================================================================================================




    }

    public void saveData()
    {
        String stringName = name.getText().toString().trim();
        String stringQuantity = quantity.getText().toString().trim();
        String stringPrice = goodPrice.getText().toString().trim();

        Shop shop = new Shop(spinnerValue,stringName,stringQuantity,stringPrice);
        if(isFilled()==false || spinnerValue.equals(getString(R.string.choose_type)))
        {
            Toast.makeText(AddGood.this,R.string.fill_data,Toast.LENGTH_LONG).show();
            return;
        }
        if(editMode==true)
        {
            shop.setId(updatedId);
            addGoodViewModel.update(shop);
        }
        else
        {
            addGoodViewModel.insert(shop);

        }
        finish();


    }


    private boolean isFilled()
    {
        if((TextUtils.isEmpty(name.getText().toString()))
        ||(TextUtils.isEmpty(quantity.getText().toString()))
        ||(TextUtils.isEmpty(goodPrice.getText().toString()))
        )
            return false;
        else
            return true;
    }

















    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerValue = spinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinnerValue = getString(R.string.good_type);
    }
}