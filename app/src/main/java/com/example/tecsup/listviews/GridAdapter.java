package com.example.tecsup.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GridAdapter  extends BaseAdapter {
    Context context;
    int layout;
    List<String>datos;

    public GridAdapter(Context context, int layout, List<String> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v=inflater.inflate(layout,null);
        TextView tv= v.findViewById(R.id.textView);
        tv.setText(datos.get(i));
        Button b=v.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,datos.get(i),Toast.LENGTH_SHORT).show();

            }
        });
        return v;
    }
}
