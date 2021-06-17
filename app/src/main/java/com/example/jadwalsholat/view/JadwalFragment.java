package com.example.jadwalsholat.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.adapter.JadwalSholatAdapter;
import com.example.jadwalsholat.model.DataItem;
import com.example.jadwalsholat.model.JadwalSholatResponse;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JadwalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JadwalFragment extends Fragment {

    private JadwalSholatAdapter jadwalSholatAdapter;
    private RecyclerView recyclerView;
    private JadwalViewModel jadwalViewModel;

    public JadwalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JadwalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JadwalFragment newInstance(String param1, String param2) {
        JadwalFragment fragment = new JadwalFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jadwalSholatAdapter = new JadwalSholatAdapter(getContext());
        jadwalSholatAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rc);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        jadwalViewModel = new ViewModelProvider(this).get(JadwalViewModel.class);
        jadwalViewModel.setJadwalSholat();
        jadwalViewModel.getJadwalSholat().observe(this, getJadwal);

        recyclerView.setAdapter(jadwalSholatAdapter);
    }

    private Observer<ArrayList<DataItem>> getJadwal = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null){
                jadwalSholatAdapter.setData(dataItems);
            }
        }
    };
}