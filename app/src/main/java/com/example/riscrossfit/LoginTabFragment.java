package com.example.riscrossfit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginTabFragment extends Fragment {

    private EditText email;
    private EditText password;
    private ProgressBar progressBar;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email = view.findViewById(R.id.emailLogin);
        password = view.findViewById(R.id.passwordLogin);
        progressBar = view.findViewById(R.id.progressLogin);

        view.findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavHostFragment.findNavController(FirstFragment.this)
                // .navigate(R.id.action_FirstFragment_to_SecondFragment);
                // execute c'est une fonction qui permet de lancer le thread

                final String emailLogin, passwordLogin;

                emailLogin = String.valueOf(email.getText());
                passwordLogin = String.valueOf(password.getText());

                if (!emailLogin.equals("") && !passwordLogin.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = emailLogin;
                            data[1] = passwordLogin;

                            PutData putData = new PutData("http://192.168.43.17:88/LoginRegisterAndroid/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Connexion reussie")) {
                                        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), EvenementActivity.class);
                                        startActivity(intent);
                                        //finish();
                                    }
                                    else {
                                        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        return root;
    }
}
