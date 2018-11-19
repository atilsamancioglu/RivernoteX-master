package birisicorp.rivernote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

public class TodosActivity extends Fragment {

    /*FloatingActionButton fab2;*/

    public TodosActivity() {


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
/*
        //Note ekleme butonu tanımı
        fab2 = Objects.requireNonNull(getActivity()).findViewById(R.id.fab);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity fab onClickListener. Buraya intent gelecek
                Intent intent = new Intent(getActivity().getApplicationContext(), AddTodo.class);
                startActivity(intent);
            }
        });
*/
        return inflater.inflate(R.layout.tab_todos, container, false);
    }

}
