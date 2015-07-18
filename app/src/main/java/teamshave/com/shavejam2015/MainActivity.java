package teamshave.com.shavejam2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    protected Button btn;
    protected TextView msg;
    protected EditText bill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.button);
        bill=(EditText)findViewById(R.id.editText);
        msg=(TextView)findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String billText = bill.getText().toString();
                double tip;
                double billAmount;

                if (!TextUtils.isEmpty(billText)) {
                    try {
                        billAmount = Double.parseDouble(bill.getText().toString());
                        tip = (billAmount / 100) * 15;
                        msg.setText(String.valueOf(tip));

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
