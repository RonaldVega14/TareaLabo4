package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    private TextView text;
    private TextView text2;
    private TextView text3;
    private ImageView imagen;
    private Objetos objeto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        text2 = view.findViewById(R.id.textId2);
        text3 = view.findViewById(R.id.textId3);
        imagen = view.findViewById(R.id.imagen);
        Bundle bundle = this.getArguments();


        if(bundle != null){
            objeto = bundle.getParcelable("KEY");
            // Toast.makeText(getActivity(), "Item: " + bundle.getString("KEY"), Toast.LENGTH_SHORT).show();
            text.setText(objeto.getNombre());
            text2.setText(objeto.getDistancia());
            text3.setText(objeto.getInfo());
            imagen.setImageResource(objeto.getImagen());


        }

        return view;
    }


}
