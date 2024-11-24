package com.example.jetpacknavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.databinding.FragmentCBinding;
import com.example.jetpacknavigation.databinding.FragmentDBinding;

public class FragmentD extends Fragment {


    private FragmentDBinding binding;

    public FragmentD() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDBinding.inflate(inflater, container, false);


        binding.logoutButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_fragmentD_to_fragmentA);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Prevent memory leaks
    }
}