package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

import pl.iroze.billingflat.flatlist.CounterAdapter;
import pl.iroze.billingflat.model.Counter;
import pl.iroze.billingflat.model.Flat;

public class FragmentCounterList extends ListFragment implements AdapterView.OnItemClickListener, WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private Flat flat;
    private Warehouse warehouse;

    private View view;
    private TextView textViewFlatAddress;
    private CounterAdapter adapter;
    private Button buttonBack;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_counter_list, container, false);

        textViewFlatAddress = view.findViewById(R.id.flat_name);
        textViewFlatAddress.setText(flat.getAdress());
        buttonBack = view.findViewById(R.id.button_back);

        buttonBack.setOnClickListener((View view) -> mListener.onFragmentFlat(flat));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new CounterAdapter(view.getContext(), warehouse.getCounterList(flat));
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Counter counter = adapter.getItem(i);
        mListener.onFragmentCounter(flat,counter);
    }
}
