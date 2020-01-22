package pl.iroze.billingflat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import pl.iroze.billingflat.model.Flat;
import pl.iroze.billingflat.model.RateElectriocity;
import pl.iroze.billingflat.model.RateGas;
import pl.iroze.billingflat.model.RateWater;

public class FragmentRate extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private Warehouse warehouse;
    private  Flat flat;

    private View view;
    private TextView electriocityDate;
    private TextView electriocityActive;//a
    private TextView electriocityTrade;//b
    private TextView electriocityQuality;//c
    private TextView electriocityVariable;//d
    private TextView electriocityOZE;//e
    private TextView electriocityNetwork;//f
    private TextView electriocityTransitional;//g
    private TextView electriocitySubscription;//h
    private TextView electriocityVAT;

    private TextView waterDate;
    private TextView waterSupplying; //supplying dostarczenieWody i Scieki
    private TextView waterHeating; //heating podgrzania
    private TextView waterCirculation; //Circulation oplataCyrkulacyjna
    private TextView waterConstant; //constant oplataStala

    private TextView gasDate;
    private TextView gasUse; //use zużycie
    private TextView gasConstant; //constant oplataStala

    private Button buttonBack;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rate, container, false);
        electriocityDate = view.findViewById(R.id.electriocity_date);
        electriocityActive = view.findViewById(R.id.electriocity_active);
        electriocityTrade = view.findViewById(R.id.electriocity_trade);
        electriocityQuality = view.findViewById(R.id.electriocity_quality);
        electriocityVariable = view.findViewById(R.id.electriocity_variable);
        electriocityOZE = view.findViewById(R.id.electriocity_oze);
        electriocityNetwork = view.findViewById(R.id.electriocity_network);
        electriocityTransitional = view.findViewById(R.id.electriocity_transitional);
        electriocitySubscription = view.findViewById(R.id.electriocity_subscription);
        electriocityVAT = view.findViewById(R.id.electriocity_vat);

        waterDate = view.findViewById(R.id.water_date);
        waterSupplying = view.findViewById(R.id.water_supplying);
        waterHeating = view.findViewById(R.id.water_heating);
        waterCirculation = view.findViewById(R.id.water_circulation);
        waterConstant = view.findViewById(R.id.water_constant);

        gasDate = view.findViewById(R.id.gas_date);
        gasUse = view.findViewById(R.id.gas_use);
        gasConstant = view.findViewById(R.id.gas_constant);

        buttonBack = view.findViewById(R.id.button_back);

        RateElectriocity rateElectriocity = flat.getRateElectriocity();
        RateWater rateWater = flat.getRateWater();
        RateGas rateGas = flat.getRateGas();

        electriocityDate.setText(String.valueOf(rateElectriocity.getDate()));
        electriocityActive.setText(String.valueOf(rateElectriocity.getActive()));
        electriocityTrade.setText(String.valueOf(rateElectriocity.getTrade()));
        electriocityQuality.setText(String.valueOf(rateElectriocity.getQuality()));
        electriocityVariable.setText(String.valueOf(rateElectriocity.getVariablel()));
        electriocityOZE.setText(String.valueOf(rateElectriocity.getOZE()));
        electriocityNetwork.setText(String.valueOf(rateElectriocity.getNetwork()));
        electriocityTransitional.setText(String.valueOf(rateElectriocity.getTransitional()));
        electriocitySubscription.setText(String.valueOf(rateElectriocity.getSubscription()));
        electriocityVAT.setText(String.valueOf(rateElectriocity.getVAT()));

        waterDate.setText(String.valueOf(rateWater.getDate()));
        waterSupplying.setText(String.valueOf(rateWater.getSupplying()));
        waterHeating.setText(String.valueOf(rateWater.getHeating()));
        waterCirculation.setText(String.valueOf(rateWater.getCirculation()));
        waterConstant.setText(String.valueOf(rateWater.getConstant()));

        gasDate.setText(String.valueOf(rateGas.getDate()));
        gasUse.setText(String.valueOf(rateGas.getUse()));
        gasConstant.setText(String.valueOf(rateGas.getConstant()));

        // powrót
        buttonBack.setOnClickListener((View view) -> {
                    mListener.onFragmentFlat(flat);
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
