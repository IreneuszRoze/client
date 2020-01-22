package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment; 

import pl.iroze.billingflat.model.Flat;

public class FragmentFlat extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;
    private TextView textViewFlatAddress;
    private TextView textViewFlatSettement;
    private Button buttonCounters;
    private Button buttonSettlementes;
    private Button buttonRate;
    private Button buttonBack;


    private Flat flat;
    private Warehouse warehouse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_flat, container, false);

        textViewFlatAddress = view.findViewById(R.id.flat_address);
        textViewFlatSettement = view.findViewById(R.id.flat_settlement);
        buttonCounters = view.findViewById(R.id.counters);
        buttonSettlementes = view.findViewById(R.id.settlementes);
        buttonRate = view.findViewById(R.id.button_rate);
        buttonBack = view.findViewById(R.id.button_back);

        textViewFlatAddress.setText(flat.getAdress());

        // liczniki (stany)
        buttonCounters.setOnClickListener((View view) -> {
            mListener.onFragmentCounterList(flat);
        });
        // rozliczenia
        buttonSettlementes.setOnClickListener((View view) -> {
            mListener.onFragmentSettlement(flat);
        });
        // stawki
        buttonRate.setOnClickListener((View view) -> {
                    mListener.onFragmentRate(flat);
                }
        );
        // powrót
        buttonBack.setOnClickListener((View view) -> {
                    mListener.onFragmentFlatList();
                }
        );

        return view;

    }


    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
