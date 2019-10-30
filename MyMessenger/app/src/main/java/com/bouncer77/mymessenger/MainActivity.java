package com.bouncer77.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMsg = (EditText) findViewById(R.id.editTextMSG);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        String msg = editTextMsg.getText().toString();
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, msg);
        startActivity(intent); // ActivityNotFoundException
    }


    public void onSendAlwaysMessage(View view) {
        String msg = editTextMsg.getText().toString();
        /*Intent.ACTION_DIAL - используется для набора номера,
          Intent.ACTION_WEB_SEARCH — для выполнения веб-поиска,
          Intent.ACTION_SEND — для отправки сообщений*/
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        intent.putExtra(Intent.EXTRA_SUBJECT, "From MyMessage");
        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent); // ActivityNotFoundException
    }

    public void onSendOtherMessage(View view) {
        String msg = editTextMsg.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        intent.putExtra(Intent.EXTRA_SUBJECT, "From MyMessage");
        String chooserTitle = getString(R.string.chooser);
        Intent choosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(choosenIntent);
    }
}
