package com.wext.clinicfy.views.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.wext.clinicfy.R;

public class Login extends AppCompatActivity {

    private SplitInstallManager manager;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        statusText = findViewById(R.id.statusText);
        manager = SplitInstallManagerFactory.create(this);
    }

    public void launchFeature(View view) {
        if (manager.getInstalledModules().contains("profile")) {
            Intent i = new Intent(
                    "com.wext.clinicfy.profile.Profile");
            startActivity(i);
        } else {
            statusText.setText("Modulo No instalado");
        }
    }
}
