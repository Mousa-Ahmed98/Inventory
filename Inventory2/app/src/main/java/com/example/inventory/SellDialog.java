package com.example.inventory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.zip.Inflater;

public class SellDialog extends AppCompatDialogFragment {

    TextView messageView;
    EditText valueView;
    private int enteredValue;
    private Shop shop;

    public SellDialog(Shop shop) {
        this.shop = shop;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_layout, null);
        messageView = view.findViewById(R.id.dialog_view);
        valueView = view.findViewById(R.id.value);
        messageView.setText(getString(R.string.dialog_message )  + shop.getName());

        builder.setView(view).setTitle("بيع").setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("بيع", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                enteredValue = Integer.parseInt(valueView.getText().toString());
                if(enteredValue>=1 && Integer.parseInt(shop.getQuantity())>=enteredValue)
                {
                    int finalValue = Integer.parseInt(shop.getQuantity())-enteredValue;

                    shop.setQuantity(String.valueOf(finalValue));
                    Toast.makeText(getContext(),getString(R.string.operation_done),Toast.LENGTH_LONG).show();
                }

                else if(Integer.parseInt(shop.getQuantity())!=0)
                {
                    Toast.makeText(getContext(),getString(R.string.not_enough_quantity),Toast.LENGTH_LONG).show();
                }



            }
        });


        return builder.create();

    }




}
