package com.example.inventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    private String spinner_value = null;

    FloatingActionButton addGood;

    private ShopViewModel modelView;
    private RecyclerView mRecyclerView;
    private DataAdapter dataAdapter;

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(spinner.getSelectedItem().toString().equals(getString(R.string.oil)))
        {
            //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }
        else if(spinner.getSelectedItem().toString().equals(getString(R.string.access)))
        {
            //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }
        else if(spinner.getSelectedItem().toString().equals(getString(R.string.cotch)))
        {
            //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }
        else if(spinner.getSelectedItem().toString().equals(getString(R.string.pieces)))
        {
            //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //spinner declaring
        spinner = (Spinner)findViewById(R.id.spinner);
        // String[] spinnerValues = {"Accessoar", "cotch", "oil", "pieces"};
        final ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.shop_contents,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        //Recycler View
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);


        //connecting recycler view with data adapter
        dataAdapter = new DataAdapter();
        mRecyclerView.setAdapter(dataAdapter);


        //this code for view model to watch the live data
        //modelView = ViewModelProviders.of(this, new MyViewModelFactory(this.getApplication(),"Awesome")).get(ShopViewModel.class);

        modelView = ViewModelProviders.of(this).get(ShopViewModel.class);





















        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //declaring a floating button
        addGood = (FloatingActionButton)findViewById(R.id.floating_action_button);





        //this line was here android:layout_marginStart="10dp"
        //        android:layout_marginEnd="10dp"

        //when clicking on the addGood button we go to the AddGood activity
        addGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this,AddGood.class);
                startActivityForResult(intent,1);

                // if Accessoirs is selected=============================================================================================
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //when clicking on items to update

        dataAdapter.OnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Shop shop) {
                Intent i  = new Intent(DataActivity.this,AddGood.class);
                i.putExtra(AddGood.EXTRA_ID,shop.getId());
                i.putExtra(AddGood.EXTRA_NAME,shop.getName());
                i.putExtra(AddGood.EXTRA_QUANTITY,shop.getQuantity());
                i.putExtra(AddGood.EXTRA_PRICE,shop.getPrice());
                i.putExtra(AddGood.EXTRA_TYPE,shop.getType());
                startActivity(i);
            }


        });






        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //when sliding on items to delete

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            //we don't need this method
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //to delete item we need to write a method in adapter view to get the index of the item

                int position = viewHolder.getAdapterPosition();
                modelView.delete(dataAdapter.getShopPosition(position));

            }
        }).attachToRecyclerView(mRecyclerView);





        //after coming back from the adding and updating activity we should refresh the live data//////////////////////////////////////////////////////////////////////




        // if oil is selected=============================================================================================



        if(spinner.getSelectedItem().toString().equals(getString(R.string.oil)))
        {
            //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }


        // if Accessoirs is selected=============================================================================================















    }




























    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // if oil is selected=============================================================================================



        if(spinner.getSelectedItem().toString().equals(getString(R.string.oil)))
        {
         //   spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataOil().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }


        // if Accessoirs is selected=============================================================================================



        if(spinner.getSelectedItem().toString().equals(getString(R.string.access)))
        {
           // spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataAccess().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }



        // if Cotch is selected=============================================================================================




        if(spinner.getSelectedItem().toString().equals(getString(R.string.cotch)))
        {
        //    spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataCotchh().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);

                }
            });
        }



        // if Pieces is selected=============================================================================================



        if(spinner.getSelectedItem().toString().equals(getString(R.string.pieces)))
        {
        //    spinner_value = spinner.getSelectedItem().toString();
            modelView.getGetAllDataPieces().observe(this, new Observer<List<Shop>>() {
                @Override
                public void onChanged(List<Shop> shops) {
                    //when any thing is changed as update, delete or insert
                    //RecyclerView will be also updated
                    //here we update the UI
                    //RecyclerView

                    //filling the dataAdapter
                    dataAdapter.setData(shops);


                }
            });
        }

    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}