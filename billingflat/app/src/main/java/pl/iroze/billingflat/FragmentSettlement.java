package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import pl.iroze.billingflat.model.Counter;
import pl.iroze.billingflat.model.Flat;

public class FragmentSettlement extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private Warehouse warehouse;
    private Flat flat;

    private View view;
    private TextView textViewFlatAddress;
    private TextView textViewArrears;
    private Button buttonPay;
    private Button buttonBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_settlement, container, false);

        textViewFlatAddress = view.findViewById(R.id.flat_address);
        textViewArrears = view.findViewById(R.id.arrears);
        buttonPay = view.findViewById(R.id.button_pay);
        buttonBack = view.findViewById(R.id.button_back);

        textViewFlatAddress.setText(flat.getAdress());

        double suma = 0;
        for (Counter counter : flat.getCounters()) {
            suma += counter.getArrears();
        }
        textViewArrears.setText(String.valueOf(suma));

        // powrót
        buttonPay.setOnClickListener((View view) -> {
                    warehouse.pay(flat);
                    mListener.onFragmentFlat(flat);
                }
        );

        // powrót
        buttonBack.setOnClickListener((View view) -> {
                    mListener.onFragmentFlat(flat);
                }
        );


        return view;
    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
