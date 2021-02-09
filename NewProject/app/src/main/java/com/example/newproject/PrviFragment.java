package com.example.newproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PrviFragment extends Fragment {

    private EditText mVisina;
    private EditText mTezina;
    private TextView mITMRacun;
    private Button mIzracun;
    private TextView mITM_BROJ;
    private static final String PorukaGreske="Molim da upišite broj i to veći od 0. ";

    private static final String BUNDLE_MESSAGE="message";

    public static PrviFragment newInstance(String message) {
        PrviFragment prvifragment = new PrviFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE,message);
        prvifragment.setArguments(args);
        return prvifragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prvi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mVisina=view.findViewById(R.id.Edit_visina);
        mTezina=view.findViewById(R.id.Edit_tezina);
        mITMRacun=view.findViewById(R.id.tvITM);
        mIzracun=view.findViewById(R.id.rdbtn);
        mITM_BROJ=view.findViewById(R.id.ITM_BROJ);
        mIzracun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String visinaOznaka = mVisina.getText().toString();
                String tezinaOznaka = mTezina.getText().toString();


                if(!visinaOznaka.equals("") && !visinaOznaka.equals("0") && !tezinaOznaka.equals("") && !tezinaOznaka.equals("0"))
                {
                    float VrijednostTezine = Float.parseFloat(tezinaOznaka);
                    float VrijednostVisine = Float.parseFloat(visinaOznaka) / 100;
                    float ITM = VrijednostTezine / (VrijednostVisine * VrijednostVisine);
                    String itm_broj=String.valueOf(ITM);
                    mITM_BROJ.setText(itm_broj);
                    podrucjeITM(ITM);
                }
                else {
                    displayToast(PorukaGreske);
                }

            }
        });


    }

    public void displayToast(String PorukaGreske){
        Toast.makeText(getActivity(), PorukaGreske , Toast.LENGTH_SHORT ).show();
    }


    public void podrucjeITM(float ITM) {
        String ITM_REZ;
        if(Float.compare(ITM,18.5f)<=0){
            ITM_REZ=getString(R.string.underweight);
        }
        else if(Float.compare(ITM,18.5f)>0 && Float.compare(ITM,24.9f)<=0){
            ITM_REZ=getString(R.string.normal);
        }
        else if(Float.compare(ITM,24.9f)>0 && Float.compare(ITM,29.9f)<=0){
            ITM_REZ=getString(R.string.overweight);
        }
        else if(Float.compare(ITM,29.9f)>0 && Float.compare(ITM,34.9f)<=0){
            ITM_REZ=getString(R.string.obese);
        }
        else {
            ITM_REZ=getString(R.string.extremely_obese);
        }
        mITMRacun.setText(ITM_REZ);
    }

}