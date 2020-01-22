package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentStart extends Fragment {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;
    private Button buttonLogIn;
    private Button buttonFlatFist; // lista mieszkań
    private Button buttonFlat; //  opis mieszkania
    private Button buttonCounterList; // lista liczników
    private Button buttonCounter; // opis licznika
    private Button buttonStates; // opis licznika

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_start, container, false);

        buttonLogIn = view.findViewById(R.id.btn_fragment_login);
        buttonFlatFist = view.findViewById(R.id.btn_fragment_list_flat);
        buttonFlat = view.findViewById(R.id.btn_fragment_flat);
        buttonCounterList = view.findViewById(R.id.btn_fragment_counter_list);
        buttonCounter = view.findViewById(R.id.btn_fragment_counter);
        buttonStates = view.findViewById(R.id.btn_fragment_states);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onFragmentLogIn();
                }
            }
        });

        buttonFlatFist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onFragmentFlatList();
                }
            }
        });

        buttonFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    //       mListener.onFragmentFlat();
                }
            }
        });

        buttonCounterList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    //     mListener.onFragmentCounterList();
                }
            }
        });

        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    //mListener.onFragmentCounter();
                }
            }
        });

        buttonStates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    //mListener.onFragmentStates();
                }
            }
        });


        return view;
    }


}