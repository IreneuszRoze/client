package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.time.LocalDate;

import pl.iroze.billingflat.model.Business;
import pl.iroze.billingflat.model.Counter;
import pl.iroze.billingflat.model.Flat;
import pl.iroze.billingflat.model.State;

public class FragmentStates extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;
    private TextView textViewCounterType;
    private TextView textViewCounterNumber;
    private TextView textViewCounterDescription;
    private TextView textViewStateLast;
    private TextView textViewStateDateLast;
    private EditText editTextStateCurrent;
    private TextView textViewStateDateCurrent;

    private Button buttonSave;
    private Button buttonBack;

    private Business business;
    private Warehouse warehouse;
    private Counter counter;
    private Flat flat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_states, container, false);

        textViewCounterType = view.findViewById(R.id.counter_type);
        textViewCounterNumber = view.findViewById(R.id.counter_number);
        textViewCounterDescription = view.findViewById(R.id.counter_description);
        textViewStateLast = view.findViewById(R.id.state_last);
        textViewStateDateLast = view.findViewById(R.id.state_date_last);
        editTextStateCurrent = view.findViewById(R.id.state_current);
        textViewStateDateCurrent = view.findViewById(R.id.state_current_date);
        buttonSave = view.findViewById(R.id.button_save);
        buttonBack = view.findViewById(R.id.button_back);

        textViewCounterType.setText(counter.getType().getName());
        textViewCounterNumber.setText(counter.getNumber());
        textViewCounterDescription.setText(counter.getDescription());

        if (counter.getLastState() != null) {
            textViewStateLast.setText(String.valueOf(counter.getLastState().getState()));
            textViewStateDateLast.setText(String.valueOf(counter.getLastState().getDate()));
        }
        textViewStateDateCurrent.setText(String.valueOf(LocalDate.now()));


        buttonSave.setOnClickListener((View view) -> {
                    String x = editTextStateCurrent.getText().toString();
                    if (!"".equals(x))
                        warehouse.setNewState(flat,counter, new State(Double.valueOf(x), LocalDate.now()));
                    mListener.onFragmentCounter(flat, counter);
                }
        );
        buttonBack.setOnClickListener((View view) ->
        {
            mListener.onFragmentCounter(flat, counter);
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editTextStateCurrent.setText("");
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
