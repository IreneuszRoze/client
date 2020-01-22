package pl.iroze.billingflat.flatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pl.iroze.billingflat.R;
import pl.iroze.billingflat.model.Counter;
import pl.iroze.billingflat.model.Flat;

public class CounterAdapter extends ArrayAdapter<Counter> {

    public CounterAdapter(Context context, ArrayList<Counter> counter) {
        super(context, R.layout.row_counter_list, counter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Counter counterRow = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_counter_list, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.row);
        String t = "";
        if (counterRow.getDescription() != null) {
            t += " " + counterRow.getDescription();
        }
        textView.setText(counterRow.getType().getName() + t);

        return convertView;
    }
}
