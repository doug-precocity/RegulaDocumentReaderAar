package com.regula.sdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class AboutActivity extends Activity {

	private TextView versionTV, emailTV, websiteTv, copyrightTv, privacyTv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_about);

		copyrightTv= (TextView) findViewById(R.id.copyrightTv);
		emailTV = (TextView) findViewById(R.id.emailTv);
		versionTV = (TextView) findViewById(R.id.versionTv);
        websiteTv =  (TextView) findViewById(R.id.websiteTv);
        privacyTv = (TextView) findViewById(R.id.privacyTv);
    }
	
	@Override
	protected void onResume() {
		super.onResume();
		try {
			versionTV.setText(DocumentReader.Instance().getLibVersion());

			Calendar calendar = Calendar.getInstance();
			String year = String.valueOf(calendar.get(Calendar.YEAR));
			copyrightTv.setText(String.format(getString(R.string.strCopyright), year));
		} catch (Exception e) {
			e.printStackTrace();
		}

        privacyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://regulaforensics.com/en/company/privacy/"));
                startActivity(intent);
            }
        });
	}
}
