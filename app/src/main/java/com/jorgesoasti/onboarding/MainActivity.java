package com.jorgesoasti.onboarding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MaterialTapTargetPrompt.Builder(MainActivity.this)
                .setTarget(findViewById(R.id.fabFoto))
                .setPrimaryText("Crear un partido")
                .setSecondaryText("Presiona para crear tu primer partido")
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
                    {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                        {
                            // User has pressed the prompt target
                            Toast.makeText(MainActivity.this, "Creando Partido..", Toast.LENGTH_SHORT).show();

                            new MaterialTapTargetPrompt.Builder(MainActivity.this)
                                    .setTarget(findViewById(R.id.btnAgregarAmigos))
                                    .setPrimaryText("Agregar Amigos")
                                    .setSecondaryText("Agrega a tus primeros amigos y forma tu equipo")
                                    .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                                    {
                                        @Override
                                        public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
                                        {
                                            if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                                            {
                                                // User has pressed the prompt target
                                            }
                                        }
                                    })
                                    .show();
                        }
                    }
                })
                .show();
    }
}
