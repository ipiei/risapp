package com.example.riscrossfit.outilHttp;

import android.util.Log;

import com.example.riscrossfit.models.User;
import com.google.gson.Gson;

public class OpenDataWS {
    private final static String URLAut = "http://192.168.43.17:88/android/authentificationUser.php";
    public static User getAuthUserWS(String email, String mdp) throws Exception {
        String URL = URLAut+"?email="+email+"&mdp="+mdp;
        Log.i("URLA", URL );
        Gson gson = new Gson();
        String reponce = OutilHttp.getHttp(URL );
        Log.i("reponse", reponce) ;
        User user = gson.fromJson(reponce, User.class);

        //Log.i("reponse", user.getPrenom()) ;

        return user;
    }
}
