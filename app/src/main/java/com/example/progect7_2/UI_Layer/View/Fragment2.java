package com.example.progect7_2.UI_Layer.View;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.model.ListData;
import com.example.progect7_2.Data.repository.Repository;
import com.example.progect7_2.R;
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment2 extends Fragment {
    private ItemsViewModel viewModel;
    String text;
    private final int PERMISSION_REQUEST_CODE = 80;

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
        //TextView textView = getActivity().findViewById(R.id.textView2);
        text = requireArguments().getString("MyArg");

        Repository repository = new Repository(this.getContext(), "listic","pushistic");

        TextView itemName = view.findViewById(R.id.textView2);

        repository.writeAppSpecDS(requireArguments().getString("MyArg"));


        itemName.setText(repository.readAppSpecDS());

        /*if(!repository.writeExternalStorageDirectory(text)){
            requestPermission();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repository.writeExternalStorageDirectory(text);
        }
        itemName.setText(repository.readExternalStorageDirectory());
*/

        //textView.setText(text);

        Bundle bundle =  new Bundle();
        TextView textView2 = getActivity().findViewById(R.id.textViewfr2);
        ImageView imageView2 = getActivity().findViewById(R.id.imageViewfr2);
        Map<String, Integer> map = new HashMap<>();
        map.put("istochnikpervojrosy", R.drawable.istochnikpervojrosy);

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemsViewModel.class);
        viewModel.createList(this.getContext(), map);
        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null ) {
                List<Cathegory> list= item.getAllCategories();
                for(Cathegory s : list){
                    if (s.img == R.drawable.istochnikpervojrosy){
                        textView2.setText(s.catName);
                        imageView2.setImageResource(s.img);
                    }
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("MyArg2", "Добро пожаловать в Тетвайт!");
                navController.navigate(R.id.fragment3, bundle);
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