package teamshave.com.shavejam2015;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    protected Button btn;
    protected TextView msg;
    protected EditText bill;
    protected EditText tipPercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.calculateButton);
        bill=(EditText)findViewById(R.id.billAmountEditText);
        msg=(TextView)findViewById(R.id.textView2);
        tipPercent=(EditText)findViewById(R.id.tipAmountEditText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String billText = bill.getText().toString();
                String tipPercentText = tipPercent.getText().toString();
                double tip;
                double billAmount;
                int tipPercent;

                // Calculate the tip percent
                if (!TextUtils.isEmpty(tipPercentText)){
                    try {
                        tipPercent = Integer.parseInt(tipPercentText);

                        if (tipPercent < 0 || tipPercent > 100) {
                            throw new NumberFormatException(getString(R.string.exception_tip_percent_outside_range));
                        }

                    } catch (NumberFormatException err) {
                        msg.setText(getString(R.string.error_invalid_tip_percent));
                        return;
                    }

                } else {
                    msg.setText(getString(R.string.error_invalid_tip_percent));
                    return;
                }

                // Calculate the bill amount
                if (!TextUtils.isEmpty(billText)) {
                    try {
                        billAmount = Double.parseDouble(bill.getText().toString());


                        tip = Calculations.CalculateTip(billAmount, tipPercent);
                        DecimalFormat df = new DecimalFormat("#.00");
                        msg.setText(df.format(tip));

                    } catch (NumberFormatException err) {
                        msg.setText(getString(R.string.error_invalid_bill_amount));
                    }


                } else {
                    msg.setText(getString(R.string.error_no_bill_amount));
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
