package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
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

        objeto[0] = new Objetos("sol", "0 km", R.drawable.sun);
        objeto[1] = new Objetos("Mercury", "57.910.000 km", R.drawable.sun);
        objeto[2] = new Objetos("Venus", "108.200.000 km", R.drawable.venus);
        objeto[3] = new Objetos("Earth", "146.600.000 km", R.drawable.earth);
        objeto[4] = new Objetos("Mars", "227.940.000 km", R.drawable.mars);
        objeto[5] = new Objetos("Jupiter", "778.330.000 km", R.drawable.jupiter);
        objeto[6] = new Objetos("Saturn", "1.429.400.000 km", R.drawable.saturn);
        objeto[7] = new Objetos("Uranus", "2.870.990.000 km", R.drawable.uranus);
        objeto[8] = new Objetos("Neptune", "4.504.300.000 km", R.drawable.neptune);

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
        String[] info = getResources().getStringArray(R.array.Dir);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            newIntent.setType("text/plain");
            newIntent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());

            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("KEY", (Parcelable) objeto[i]);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();


            Bundle bundle = new Bundle();
            bundle.putString("KEY", adapterView.getItemAtPosition(i).toString());
            bundle.putString("KEY2", info[i]);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
