package com.example.billcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.Gravity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.util.List;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        List<MainActivity.Item> itemList = (List<MainActivity.Item>) getIntent().getSerializableExtra("itemList");
        double totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);
        double discountPercentage = Double.parseDouble(getIntent().getStringExtra("discount"));

        double discountAmount = totalAmount * (discountPercentage / 100);

        double totalAmountAfterDiscount = totalAmount - discountAmount;

        TableLayout tableLayoutItems = findViewById(R.id.tableLayoutItems);
        TableRow headerRow = new TableRow(this);

        TextView headerItemName = new TextView(this);
        headerItemName.setText("Item Name");
        headerItemName.setPadding(20, 20, 20, 20);
        headerItemName.setGravity(Gravity.CENTER);
        headerItemName.setTextSize(18);
        headerRow.addView(headerItemName);

        TextView headerItemPrice = new TextView(this);
        headerItemPrice.setText("Item Price");
        headerItemPrice.setPadding(20, 20, 20, 20);
        headerItemPrice.setGravity(Gravity.CENTER);
        headerItemPrice.setTextSize(18);
        headerRow.addView(headerItemPrice);

        TextView headerItemQuantity = new TextView(this);
        headerItemQuantity.setText("Item Quantity");
        headerItemQuantity.setPadding(20, 20, 20, 20);
        headerItemQuantity.setGravity(Gravity.CENTER);
        headerItemQuantity.setTextSize(18);
        headerRow.addView(headerItemQuantity);

        tableLayoutItems.addView(headerRow);

        for (MainActivity.Item item : itemList) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView itemName = new TextView(this);
            itemName.setText(item.getName());
            itemName.setPadding(20, 20, 20, 20);
            itemName.setGravity(Gravity.CENTER);
            itemName.setTextSize(16);
            row.addView(itemName);

            TextView itemPrice = new TextView(this);
            itemPrice.setText(String.valueOf(item.getPrice()));
            itemPrice.setPadding(20, 20, 20, 20);
            itemPrice.setGravity(Gravity.CENTER);
            itemPrice.setTextSize(16);
            row.addView(itemPrice);

            TextView itemQuantity = new TextView(this);
            itemQuantity.setText(String.valueOf(item.getQuantity()));
            itemQuantity.setPadding(20, 20, 20, 20);
            itemQuantity.setGravity(Gravity.CENTER);
            itemQuantity.setTextSize(16);
            row.addView(itemQuantity);

            tableLayoutItems.addView(row);
        }

        TextView textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        TextView textViewDiscountAmount = findViewById(R.id.textViewDiscountAmount);
        textViewTotalAmount.setText("Total Amount (incl. discount): ₹" + totalAmountAfterDiscount);
        textViewDiscountAmount.setText("Discount: ₹" + discountAmount);

        Button buttonPrint = findViewById(R.id.buttonPrint);
        buttonPrint.setOnClickListener(v -> printReceipt(itemList, totalAmountAfterDiscount, discountAmount));
    }

    private void printReceipt(List<MainActivity.Item> itemList, double totalAmount, double discountAmount) {
        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                createWebPrintJob(view);
            }
        });

        String htmlDocument = generateReceiptHTML(itemList, totalAmount, discountAmount);
        webView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
    }

    private void createWebPrintJob(WebView webView) {
        PrintManager printManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
        }
        PrintDocumentAdapter printAdapter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            printAdapter = webView.createPrintDocumentAdapter("Receipt");
        }
        String jobName = getString(R.string.app_name) + " Document";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
        }
    }

    private String generateReceiptHTML(List<MainActivity.Item> itemList, double totalAmount, double discountAmount) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html><body>");
        htmlContent.append("<h1>Receipt</h1>");
        htmlContent.append("<table border=\"1\">");
        htmlContent.append("<tr><th>Item Name</th><th>Item Price</th><th>Item Quantity</th></tr>");
        for (MainActivity.Item item : itemList) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(item.getName()).append("</td>");
            htmlContent.append("<td>").append(item.getPrice()).append("</td>");
            htmlContent.append("<td>").append(item.getQuantity()).append("</td>");
            htmlContent.append("</tr>");
        }
        htmlContent.append("</table>");
        htmlContent.append("<p>Total Amount (incl. discount): ₹").append(totalAmount).append("</p>");
        htmlContent.append("<p>Discount: ₹").append(discountAmount).append("</p>");
        htmlContent.append("</body></html>");
        return htmlContent.toString();
    }
}
