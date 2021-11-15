package com.example.telegram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContAdapter extends BaseAdapter {
    private List<Cont> listaCont=new ArrayList<>();

    public ContAdapter(List<Cont> lista) {
        listaCont = lista;
    }

    @Override
    public int getCount() {
        return listaCont.size();
    }

    @Override
    public Cont getItem(int position) {
        return listaCont.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.macheta_cont, viewGroup, false);
        TextView tvDenumire=v.findViewById(R.id.tvDenumire);
        TextView tvVarsta=v.findViewById(R.id.tvVarsta);
        TextView tvEmail=v.findViewById(R.id.tvEmail);


        Cont temp=listaCont.get(position);
        tvDenumire.setText(temp.getDenumire());
        tvVarsta.setText(temp.getVarsta().toString());
        tvEmail.setText(temp.getEmail());

        return v;
    }

    public void updateList(List<Cont> listaNoua)
    {
        listaCont.clear();
        listaCont.addAll(listaNoua);

        notifyDataSetChanged();
    }
}
