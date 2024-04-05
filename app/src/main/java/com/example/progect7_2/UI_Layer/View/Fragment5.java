package com.example.progect7_2.UI_Layer.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.progect7_2.R;
//import com.example.progect7_2.UI_Layer.viewmodel.ItemDetailViewModel;

public class Fragment5 extends Fragment {
    //private ItemDetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);

        /*viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemDetailViewModel.class);

        int itemId = getArguments().getInt("itemId");
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.textView);
                ImageView itemDescription = view.findViewById(R.id.imageView);
                itemName.setText(item.getName());
                itemDescription.setImageResource(item.getImage());
            }
        });*/


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        Button button = getActivity().findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.fragment4);
            }
        });
    }
}