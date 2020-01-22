package pl.iroze.billingflat;

import android.content.Context;
import android.util.Base64;

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

import pl.iroze.billingflat.model.Business;

public class Connector {



    private static final int SOCKET_TIMEOUT = 20000;
    private RequestQueue mRequestQueue;
    private String url = "https://billingflat.herokuapp.com/get";

    private StringRequest mStringRequest;
    private JsonArrayRequest jsonArrayRequest;
    private JsonObjectRequest jsonObjectRequest;

    private Context context;

    Business getDane() {
        return null;
    }

    public Connector(Context context)
    {
        this.context = context;
        //getApplicationContext()
    }

    private void sendAndRequestResponse() {

        mRequestQueue = Volley.newRequestQueue(context);

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
