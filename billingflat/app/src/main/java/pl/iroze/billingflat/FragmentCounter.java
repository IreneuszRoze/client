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

public class FragmentCounter extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;
    private TextView textViewCounterNumber;
    private TextView textViewCounterType;
    private TextView textViewCounterDescription;
    private TextView textViewCounterState;
    private TextView textViewCounterStateDate;

    private TextView textViewCounterStateSettlemen;
    private TextView textViewCounterStateSettlementDate;

    private TextView textViewArrears;

    private Button buttonCounterState;
    private Button buttonBack;

    private Warehouse warehouse;
    private Counter counter;
    private Flat flat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_counter, container, false);

        textViewCounterNumber = view.findViewById(R.id.counter_number);
        textViewCounterType = view.findViewById(R.id.counter_type);
        textViewCounterDescription = view.findViewById(R.id.counter_description);
        textViewCounterState = view.findViewById(R.id.counter_state);
        textViewCounterStateDate = view.findViewById(R.id.counter_state_date);
        textViewCounterStateSettlemen = view.findViewById(R.id.counter_state_settlement);
        textViewCounterStateSettlementDate = view.findViewById(R.id.counter_state_settlement_date);
        textViewArrears = view.findViewById(R.id.arrears);
        buttonCounterState = view.findViewById(R.id.button_counter_state);
        buttonBack = view.findViewById(R.id.button_back);

        textViewCounterNumber.setText(counter.getNumber());
        textViewCounterType.setText(counter.getType().getName());
        textViewCounterDescription.setText(counter.getDescription());
        if (counter.getSettledState() != null) {
            textViewCounterStateSettlemen.setText(String.valueOf(counter.getSettledState().getState()));
            textViewCounterStateSettlementDate.setText(String.valueOf(counter.getSettledState().getDate()));
        }
        if (counter.getLastState() != null) {
            textViewCounterState.setText(String.valueOf(counter.getLastState().getState()));
            textViewCounterStateDate.setText(String.valueOf(counter.getLastState().getDate()));
        }
        textViewArrears.setText(String.valueOf(counter.getArrears()));

        buttonCounterState.setOnClickListener((View view) -> {
            mListener.onFragmentStates(flat,counter);
        });
        // powrót
        buttonBack.setOnClickListener((View view) -> {
                    mListener.onFragmentCounterList(flat);
                }
        );
        return view;

    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}


