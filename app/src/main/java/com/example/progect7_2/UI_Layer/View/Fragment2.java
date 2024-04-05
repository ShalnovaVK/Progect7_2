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
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;

public class Fragment2 extends Fragment {
    //private ItemDetailViewModel viewModel;
    String text;

    public Fragment2() {
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
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        Button button = getActivity().findViewById(R.id.button2);
        TextView textView = getActivity().findViewById(R.id.textView2);
        text = requireArguments().getString("MyArg");
        textView.setText(text);

        Bundle bundle =  new Bundle();




       /* viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemDetailViewModel.class);

        int itemId = R.drawable.istochnikpervojrosy;
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.textViewfr2);
                ImageView itemDescription = view.findViewById(R.id.imageViewfr2);
                itemName.setText(item.getName());
                itemDescription.setImageResource(item.getImage());
            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("MyArg2", "Добро пожаловать в Тетвайт!");
                navController.navigate(R.id.fragment3, bundle);
            }
        });
    }
}