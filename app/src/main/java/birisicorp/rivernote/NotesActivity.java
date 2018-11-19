package birisicorp.rivernote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class NotesActivity extends Fragment {

    View view;
    ListView listView;
    PostClass adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ArrayList<String> titleFromFirebase;
    ArrayList<String> descFromFirebase;
    ArrayList<String> imageFromFirebase;

    public NotesActivity(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //listView = getActivity().findViewById(R.id.notesListview);
        titleFromFirebase = new ArrayList<>();
        descFromFirebase = new ArrayList<>();
        imageFromFirebase = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        //listView.setAdapter(adapter);
        getDataFromFirebase();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(view==null)
        {
            view=inflater.inflate(R.layout.tab_notes, container,false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }


        listView = (ListView) view.findViewById(R.id.notesListview);
        adapter = new PostClass(titleFromFirebase, descFromFirebase, imageFromFirebase, getActivity());
        listView.setAdapter(adapter);
        return view;

    }
    public void getDataFromFirebase() {

        DatabaseReference newReferance = firebaseDatabase.getReference("Users").child("Notes");
        newReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HashMap<String, String> hashMap = (HashMap<String, String>) ds.getValue();
                    titleFromFirebase.add(hashMap.get("title"));
                    descFromFirebase.add(hashMap.get("content"));
                    imageFromFirebase.add(hashMap.get("downloadurl"));
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
