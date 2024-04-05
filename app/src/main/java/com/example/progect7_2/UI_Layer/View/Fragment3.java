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

public class Fragment3 extends Fragment {
    //private ItemDetailViewModel viewModel;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        TextView textView = getActivity().findViewById(R.id.textView3);
        String text = requireArguments().getString("MyArg2");
        textView.setText(text);

        /*viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemDetailViewModel.class);

        int itemId = R.drawable.mika;
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.textViewfr3);
                ImageView itemDescription = view.findViewById(R.id.imageViewfr3);
                itemName.setText(item.getName());
                itemDescription.setImageResource(item.getImage());
            }
        });*/


        Button button = getActivity().findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.fragment4);
            }
        });
    }
}