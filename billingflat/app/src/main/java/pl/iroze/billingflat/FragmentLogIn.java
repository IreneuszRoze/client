package pl.iroze.billingflat;

import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class FragmentLogIn extends Fragment implements WarehouseInside {

    public MainActivity.OnFragmentInteractionListener mListener;

    private View view;

    private Button buttonSignIn;
    private EditText editTextEmial;
    private EditText editTextPassword;
    private ProgressBar progressBar;

    private Warehouse warehouse;

    private static final int SOCKET_TIMEOUT = 20000;
    private RequestQueue mRequestQueue;
    private String url = "https://billingflat.herokuapp.com/get";

    private StringRequest mStringRequest;
    private JsonArrayRequest jsonArrayRequest;
    private JsonObjectRequest jsonObjectRequest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        buttonSignIn = (Button) view.findViewById(R.id.buttonSignIn);
        editTextEmial = (EditText) view.findViewById(R.id.editTextEmial);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar_cyclic);

        buttonSignIn.setOnClickListener((View view) -> {
            progressBar.setVisibility(View.VISIBLE);
            sendAndRequestResponse();
            //  mListener.onFragmentFlatList();
        });

        return view;

    }


    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    private void sendAndRequestResponse() {

        mRequestQueue = Volley.newRequestQueue(getContext());

        jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonObject) {
                        //           Gson gson = new Gson();
                        //            Business business = gson.fromJson(object.toString(), Business.class);
                        // textView.setText("OK");
                        //   textView.setText(jsonObject.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {
                    //     textView.setText("wlacz transmisje danych");

                } else if (error instanceof TimeoutError) {

                    //           textView.setText("ERROR_TIMEOUT");
                } else {

                    NetworkResponse networkResponse = error.networkResponse;
                    if (networkResponse != null) {
                        String errorCode = String.valueOf(networkResponse.statusCode);

                        error.printStackTrace();
                        //    textView.setText(error.getMessage() + ' ' + errorCode);
                    }

                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s", "admin", "password");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                params.put("Content-Type", "application/json; charset=utf-8");
                return params;
            }
        }

        ;

        //      jsonObjectRequest.setTag(TAG);
        //  jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(SOCKET_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(jsonArrayRequest);
    }
}