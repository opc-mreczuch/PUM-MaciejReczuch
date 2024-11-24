package com.example.jetpacknavigation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpacknavigation.databinding.FragmentCBinding;

public class FragmentC extends Fragment {

    private FragmentCBinding binding;

    public FragmentC() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCBinding.inflate(inflater, container, false);

        binding.registerButton.setOnClickListener(view -> {
            String username = binding.usernameEditText.getText().toString();
            String password = binding.passwordEditText.getText().toString();
            String confirmPassword = binding.confirmPasswordEditText.getText().toString();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(getContext(), "Wszystkie pola muszą być wypełnione", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(getContext(), "Hasła muszą być takie same", Toast.LENGTH_SHORT).show();
                return;
            }

            if (UserManager.register(username, password)) {
                Toast.makeText(getContext(), "Zarejestrowano pomyślnie", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentB);
            } else {
                Toast.makeText(getContext(), "Użytkownik o tej nazwie już istnieje", Toast.LENGTH_SHORT).show();
            }
        });

        binding.BackButton.setOnClickListener(view -> {

            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentA);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Prevent memory leaks
    }
}
