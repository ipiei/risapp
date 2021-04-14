package com.example.riscrossfit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignupTabFragment extends Fragment {

    private EditText surname;
    private EditText name;
    private EditText email;
    private EditText password;
    //TextView textViewLogin;
    private ProgressBar progressBar;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        surname = view.findViewById(R.id.surnameSignup);
        name = view.findViewById(R.id.nameSignup);
        email = view.findViewById(R.id.emailSignup);
        password= view.findViewById(R.id.passwordSignup);
        progressBar = view.findViewById(R.id.progressSignup);

        view.findViewById(R.id.buttonSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavHostFragment.findNavController(FirstFragment.this)
                // .navigate(R.id.action_FirstFragment_to_SecondFragment);
                // execute c'est une fonction qui permet de lancer le thread

                final String surnameSignup, nameSignup, emailSignup, passwordSignup;

                surnameSignup = String.valueOf(surname.getText());
                nameSignup = String.valueOf(name.getText());
                emailSignup = String.valueOf(email.getText());
                passwordSignup = String.valueOf(password.getText());

                if(!surnameSignup.equals("") && !nameSignup.equals("") && !emailSignup.equals("") && !passwordSignup.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler();
                    handler.post (new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "nom";
                            field[1] = "prenom";
                            field[2] = "email";
                            field[3] = "password";

                            String[] data = new String[4];
                            data[0] = surnameSignup;
                            data[1] = nameSignup;
                            data[2] = emailSignup;
                            data[3] = passwordSignup;

                            PutData putData = new PutData("http://192.168.43.17:88/LoginRegisterAndroid/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Inscription reussie")){
                                        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), LoginActivity.class);
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
                }
                else {
                    Toast.makeText(getActivity(), "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        return root;
    }
}
