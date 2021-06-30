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
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class vendorList extends AppCompatActivity {

    TextView tv_vendor;
    ListView vendor;
    Button back;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);  //removes status bar
        setContentView(R.layout.activity_vendor_list);

        tv_vendor=findViewById(R.id.textview_vendorList);
        vendor=findViewById(R.id.vendor_list);
        back=findViewById(R.id.back);

        Intent in=getIntent();
        final String user=in.getStringExtra("username");
        tv_vendor.setText(user+", Your Vendor List");

        reference= FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {

            ArrayList<String> keys=new ArrayList<String>();
            ArrayList<String> values=new ArrayList<String>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot subSnap:dataSnapshot.getChildren())
                {
                    String str=dataSnapshot.child(subSnap.getKey()).child("type").getValue().toString(); //=Customer
                    //String str=subSnap.getKey();  //==Username
                    if(str.equals("Vendor"))
                    {
                        keys.add(subSnap.getKey());
                        //String str1=dataSnapshot.child(subSnap.getKey()).child("Vendor").getValue().toString(); //=vendor list

                        DataSnapshot vendor_veg=dataSnapshot.child(subSnap.getKey()).child("Vendor");
                        String vendor_veg_list="";

                        for(DataSnapshot each_veg:vendor_veg.getChildren())
                        {
                            String veg_name=each_veg.getKey();
                            String veg_weight=vendor_veg.child(veg_name).child("weight").getValue().toString();
                            String veg_price=vendor_veg.child(veg_name).child("price").getValue().toString();
                            if(!veg_weight.equals("0"))
                                vendor_veg_list+=veg_name+" = "+veg_weight+" kg @ Rs "+veg_price+"\n";
                        }
                        values.add(vendor_veg_list);
                        //Toast.makeText(vendorList.this,str1,Toast.LENGTH_LONG).show();
                    }
                }
                MyAdapter adapter=new MyAdapter(vendorList.this,keys,values);
                vendor.setAdapter(adapter);

                vendor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in=new Intent(vendorList.this,viewInfo.class);
                        in.putExtra("username",user);
                        startActivity(in);
                        finish();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        ArrayList<String> rTitle;
        ArrayList<String> rDescription;

        MyAdapter (Context c, ArrayList<String> title, ArrayList<String> description) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            myTitle.setText(rTitle.get(position));
            myDescription.setText(rDescription.get(position));

            return row;
        }
    }

}
