package com.example.inventory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopTable")
public class Shop {
    //id
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo( name = "id")
    private int id;

    // type
    @ColumnInfo (name="type")
    private String type;

    //name
    @ColumnInfo (name="name")
    private String name;

    //quantity
    @ColumnInfo (name="quantity")
    private String quantity;


    //price
    @ColumnInfo (name="price")
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }



    public String getQuantity() {
        return quantity;
    }



    public String getPrice() {
        return price;
    }







  public Shop(String type, String name, String quantity, String price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
