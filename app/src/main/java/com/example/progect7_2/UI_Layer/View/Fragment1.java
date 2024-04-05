package com.example.progect7_2.UI_Layer.View;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.progect7_2.Data.repository.Repository;
import com.example.progect7_2.R;
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {
    private ItemsViewModel viewModel;
    private final int PERMISSION_REQUEST_CODE = 80;

    public Fragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        Button button = getActivity().findViewById(R.id.button);
        Bundle bundle =  new Bundle();

        EditText editText = getActivity().findViewById(R.id.editText);

        Repository repository = new Repository(this.getContext(), "listic","pushistic");
        repository.writeAppSpecDS("Архонты следят за вами через глаза бога!");
        TextView itemName = view.findViewById(R.id.textViewfr1);
        //itemName.setText(repository.readAppSpecDS());

        if(!repository.writeExternalStorageDirectory("Убери за собой")){
            requestPermission();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repository.writeExternalStorageDirectory("Убери за собой");
        }


        //Задание 2
        //TextView itemName = view.findViewById(R.id.textViewfr1);

        itemName.setText(repository.readExternalStorageDirectory());


        // 3) SharedPreferencesDS
        //TextView itemName = view.findViewById(R.id.textViewfr1);
        ImageView imageView = view.findViewById(R.id.imageViewfr1);

        repository.createLocalds(this.getContext());
        repository.setLocalName("temnozvezdnik");
        repository.setLocalImg(R.drawable.temnozvezdnik);

        //itemName.setText(repository.getItems().getName());
        imageView.setImageResource(repository.getItems().getImage());


        /*viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemsViewModel.class);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("temnozvezdnik");
        viewModel.createList(this.getActivity(),arrayList);

        int itemId = R.drawable.temnozvezdnik;


        viewModel.getItemsObserv().observe(getViewLifecycleOwner(), new Observer<List<Cathegory>>() {
            @Override
            public void onChanged(List<Cathegory> cathegories) {
                if (cathegories == null){
                    TextView itemName = view.findViewById(R.id.textViewfr1);
                    itemName.setText("No data(((");
                }else{
                    TextView itemName = view.findViewById(R.id.textViewfr1);
                    itemName.setText("Yes data(((");
                }
            }
        });

        /*
        viewModel.getItem(itemId).observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemName = view.findViewById(R.id.textViewfr1);
                ImageView itemDescription = view.findViewById(R.id.imageViewfr1);
                itemName.setText(item.getName());
                itemDescription.setImageResource(item.getImage());
            }
        });*/



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("MyArg","Привет, "+String.valueOf(editText.getText()));
                navController.navigate(R.id.fragment2, bundle);
            }
        });
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getContext(), "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.e("value", "Permission Granted, Now you can use local drive .");
                }
                break;
        }
    }
}