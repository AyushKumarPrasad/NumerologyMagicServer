package turnup.ideas.numerology.magic.numerologymagicserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import turnup.ideas.numerology.magic.numerologymagicserver.Model.Common;
import turnup.ideas.numerology.magic.numerologymagicserver.Model.User;

public class GetNames extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<User, NameViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference requests   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_names);

        database = FirebaseDatabase.getInstance();
        requests = database.getReference("User");

        recyclerView = (RecyclerView) findViewById(R.id.retrieve_profile_getNames);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadOrders();
    }

    private void loadOrders()
    {
        adapter = new FirebaseRecyclerAdapter<User,  NameViewHolder>
                (
                        User.class,
                        R.layout.retreive_names,
                        NameViewHolder.class,
                        requests
                )
        {
            @Override
            protected void populateViewHolder( NameViewHolder viewHolder, final User model, int position)
            {
                viewHolder.txtNames.setText(model.getName());

                viewHolder.txtMobile.setText(model.getPhone());

                viewHolder.itemClickListener = new ItemClickListener()
                {
                    @Override
                    public void onClick(View view, int position)
                    {
                        if (! model.getName().equals(Common.currentUser.getName()))
                        {
                            Intent map = new Intent(GetNames.this, MessageList.class);
                            map.putExtra("name", model.getName());
                            startActivity(map);
                        }
                        else
                        {
                            Toast.makeText(GetNames.this,"How can you chat with yourself" , Toast.LENGTH_SHORT).show();
                        }
                    }
                };


            }
        };
        recyclerView.setAdapter(adapter);
    }
}
