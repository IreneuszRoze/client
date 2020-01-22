package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

import pl.iroze.billingflat.flatlist.FlatAdapter;

import pl.iroze.billingflat.model.Business;
import pl.iroze.billingflat.model.Example;
import pl.iroze.billingflat.model.Flat;

public class FragmentFlatList extends ListFragment implements AdapterView.OnItemClickListener,WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;

    private FlatAdapter adapter;

    private Warehouse warehouse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_flat_list, container, false);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new FlatAdapter(view.getContext(), warehouse.getFlats());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //  Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Flat x = adapter.getItem(position);
        mListener.onFragmentFlat(x);

    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
