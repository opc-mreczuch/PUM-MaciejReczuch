package com.example.jetpacknavigation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    private @NonNull FragmentBBinding binding;

    public FragmentB() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = com.example.jetpacknavigation.databinding.FragmentBBinding.inflate(inflater, container, false);

        binding.loginButton.setOnClickListener(view -> {
            String username = binding.usernameEditText.getText().toString();
            String password = binding.passwordEditText.getText().toString();

            if (UserManager.login(username, password)) {

                Toast.makeText(getContext(), "Zalogowano!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentD);
            } else {

                Toast.makeText(getContext(), "Błędna nazwa użytkownika lub hasło!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.registerButton.setOnClickListener(view -> {

            Navigation.findNavController(view).navigate(R.id.action_fragmentB_to_fragmentC);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Prevent memory leaks
    }
}
