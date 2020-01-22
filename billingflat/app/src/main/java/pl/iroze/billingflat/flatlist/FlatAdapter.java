package pl.iroze.billingflat.flatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pl.iroze.billingflat.R;
import pl.iroze.billingflat.model.Flat;

public class FlatAdapter extends ArrayAdapter<Flat> {

    public FlatAdapter(Context context, ArrayList<Flat> flat) {
        super(context, R.layout.row_flat_list, flat);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Flat flatRow = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_flat_list, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.row);
        textView.setText(flatRow.getAdress() +  " " + flatRow.getRole().getName());

        return convertView;
    }

}
