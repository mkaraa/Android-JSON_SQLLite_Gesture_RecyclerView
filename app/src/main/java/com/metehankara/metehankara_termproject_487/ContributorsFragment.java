package com.metehankara.metehankara_termproject_487;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ContributorsFragment extends Fragment {
    ImageView imgLogo;
    JSONObject object;
    JSONArray jarray;

    private ArrayList<HashMap<String, String>> mArrayList;

    public static final String TAG_BOOKS = "contributors";
    public static final String TAG_NAME = "name";
    public static final String TAG_SURNAME = "surname";
    public static final String TAG_AGE = "age";

    TextView name,surname,age;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contributor_fragment_layout, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name= view.findViewById(R.id.nameFragmentTxt);
        surname = view.findViewById(R.id.surnameFragmentTxt);
        age = view.findViewById(R.id.ageFragmentTxt);


        parseJSON(loadFileFromAssets("contributors.json"));



    }

    private void parseJSON(String json){


        if (json != null) {
            try {
                object = new JSONObject(json);
                // Getting JSON Array
                jarray = object.getJSONArray(TAG_BOOKS);


                    JSONObject c = jarray.getJSONObject(0);


                    name.setText(c.getString(TAG_NAME));
                surname.setText(c.getString(TAG_SURNAME));
                age.setText(c.getString(TAG_AGE));






            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

    }

    private String loadFileFromAssets(String fileName) {
        String fileContent = null;
        try {

            InputStream is = getActivity().getBaseContext().getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            fileContent = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return fileContent;
    }
}
