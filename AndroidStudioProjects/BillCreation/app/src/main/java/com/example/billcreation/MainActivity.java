package com.example.billcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextItemName, editTextItemPrice, editTextItemQuantity, editTextDiscount;
    private Spinner spinnerQuantityUnit;
    private Button buttonAddItem, buttonClear, buttonGenerateBill;
    private TextView textViewTotalAmount, textViewDiscountAmount;

    private List<Item> itemList;
    private ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextDiscount = findViewById(R.id.editTextDiscount);
        spinnerQuantityUnit = findViewById(R.id.spinnerQuantityUnit);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        buttonClear = findViewById(R.id.buttonClear);
        buttonGenerateBill = findViewById(R.id.buttonGenerateBill);
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        textViewDiscountAmount = findViewById(R.id.textViewDiscountAmount);
        ListView listViewItems = findViewById(R.id.listViewItems);

        // Initialize item list and adapter
        itemList = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listViewItems.setAdapter(itemsAdapter);

        // Set up the spinner for quantity units
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.quantity_units, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantityUnit.setAdapter(spinnerAdapter);

        // Add item button click listener
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToList();
            }
        });

        // Clear button click listener
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        // Generate bill button click listener
        buttonGenerateBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateBill();
            }
        });

        // Add text changed listener to discount EditText
        editTextDiscount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateTotalAmount();
            }
        });
    }

    private void addItemToList() {
        // Get input values
        String itemName = editTextItemName.getText().toString().trim();
        String itemPriceStr = editTextItemPrice.getText().toString().trim();
        String itemQuantityStr = editTextItemQuantity.getText().toString().trim();
        String quantityUnit = spinnerQuantityUnit.getSelectedItem().toString();

        // Validate input
        if (itemName.isEmpty() || itemPriceStr.isEmpty() || itemQuantityStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double itemPrice = Double.parseDouble(itemPriceStr);
        int itemQuantity = Integer.parseInt(itemQuantityStr);

        // Add item to the list
        itemList.add(new Item(itemName, itemPrice, itemQuantity, quantityUnit));

        // Update the list view
        itemsAdapter.add(itemName + " - ₹" + itemPrice + " x " + itemQuantity + " " + quantityUnit);
        itemsAdapter.notifyDataSetChanged();

        // Clear input fields
        clearFields();
    }

    private void updateTotalAmount() {
        double totalAmount = calculateTotalAmount();
        String discountStr = editTextDiscount.getText().toString().trim();
        double discount = discountStr.isEmpty() ? 0.0 : Double.parseDouble(discountStr);
        double discountAmount = totalAmount * (discount / 100);
        double discountedTotal = totalAmount - discountAmount;

        textViewTotalAmount.setText(String.format("Total Amount: ₹%.2f", discountedTotal));
        textViewDiscountAmount.setText(String.format("Discount Amount: ₹%.2f", discountAmount));
    }

    private void clearFields() {
        editTextItemName.setText("");
        editTextItemPrice.setText("");
        editTextItemQuantity.setText("");
        editTextDiscount.setText("");
    }


    private void generateBill() {
        // Start the new activity to display the bill
        Intent intent = new Intent(MainActivity.this, ReceiptActivity.class);
        intent.putExtra("itemList", (Serializable) itemList);
        intent.putExtra("totalAmount", calculateTotalAmount());
        intent.putExtra("discount", editTextDiscount.getText().toString().trim());
        startActivity(intent);
    }

    private double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (Item item : itemList) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }

    public static class Item implements Serializable {
        private String name;
        private double price;
        private int quantity;
        private String quantityUnit;

        public Item(String name, double price, int quantity, String quantityUnit) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.quantityUnit = quantityUnit;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getQuantityUnit() {
            return quantityUnit;
        }
    }
}
