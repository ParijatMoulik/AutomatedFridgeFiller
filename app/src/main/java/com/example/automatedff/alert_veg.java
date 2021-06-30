package com.example.automatedff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class alert_veg extends AppCompatActivity {

    ListView alert_list;
    DatabaseReference reference;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_veg);

        tv=findViewById(R.id.textview_alert);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        tv.setText("username");

        Toast.makeText(alert_veg.this, username,Toast.LENGTH_LONG).show();
    }
//        reference = FirebaseDatabase.getInstance().getReference("users").child(username).child("Master");
//        reference.addValueEventListener(new ValueEventListener() {
//            ArrayList<String> keys = new ArrayList<String>();
//            ArrayList<String> values = new ArrayList<>();
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot subSnap : dataSnapshot.getChildren()) {
//                    String value = dataSnapshot.child(subSnap.getKey()).getValue().toString();
//                    if (!value.equals("0")) {
//                        keys.add(subSnap.getKey());
//                        values.add((String) subSnap.getValue());
//                    }
//                }
//                MyAdapter adapter = new MyAdapter(alert_veg.this, keys, values);
//                alert_list.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//        });
//    }
//
//    class MyAdapter extends ArrayAdapter<String> {
//
//        Context context;
//        ArrayList<String> rTitle;
//        ArrayList<String> rDescription;
//
//        MyAdapter (Context c, ArrayList<String> title, ArrayList<String> description) {
//            super(c, R.layout.row, R.id.textView1, title);
//            this.context = c;
//            this.rTitle = title;
//            this.rDescription = description;
//
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.row, parent, false);
//            TextView myTitle = row.findViewById(R.id.textView1);
//            TextView myDescription = row.findViewById(R.id.textView2);
//
//            // now set our resources on views
//            myTitle.setText(rTitle.get(position));
//            myDescription.setText("Weight: "+rDescription.get(position)+" kg");
//
//
//            return row;
//        }
//    }
}