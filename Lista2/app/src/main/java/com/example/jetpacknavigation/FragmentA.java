package com.example.jetpacknavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding binding;

    public FragmentA() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(inflater, container, false);


        binding.loginButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentB);
        });

        binding.registerButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentC);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

