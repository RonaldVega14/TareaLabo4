package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{
    private Objetos objeto[] = new Objetos[9];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] info = getResources().getStringArray(R.array.Dir);
        String[] nombre = getResources().getStringArray(R.array.Planets);
        String[] inf = getResources().getStringArray(R.array.inf);
        TypedArray img = getResources().obtainTypedArray(R.array.img);


        for(int i=0; i<objeto.length; i++){
            objeto[i] = new Objetos(nombre[i], info[i], img.getResourceId(i, -1), inf[i]);
        }

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1); //Busca en strings.xml
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("KEY", objeto[i]);

            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.putExtras(bundle2);
            startActivity(newIntent);

        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();


            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY", objeto[i]);

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
