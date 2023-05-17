package com.ugb.catalogo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import android.content.Intent;




public class MarcasFragment extends Fragment {


    CardView adidas;
    CardView nike;
    CardView jordan;
    CardView puma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marcas, container, false);

        nike = view.findViewById(R.id.nike);
        nike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), nike.class);
                startActivity(intent);
            }


        });

        puma = view.findViewById(R.id.puma);
        puma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), puma.class);
                startActivity(intent);
            }


        });

        jordan = view.findViewById(R.id.jordan);
        jordan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), jordan.class);
                startActivity(intent);
            }


        });

        adidas = view.findViewById(R.id.adidas);
        adidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), adidas.class);

                startActivity(intent);
            }
        });



        return view;

    }


}