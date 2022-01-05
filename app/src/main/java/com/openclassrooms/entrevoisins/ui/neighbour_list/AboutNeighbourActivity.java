package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.io.Serializable;
import java.util.List;



public class AboutNeighbourActivity extends AppCompatActivity {


    public DummyNeighbourApiService varPerso;
    private int idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_neighbour);










        Intent intent = this.getIntent();

        Serializable ser = intent.getSerializableExtra("test");

        Neighbour neighbour = null;

        if(ser instanceof Neighbour)
        {
            neighbour = (Neighbour) ser;



            this.idUser = (int) neighbour.getId();


            TextView viewNom = this.findViewById(R.id.textViewHaut);
            viewNom.setText(neighbour.getName());


            TextView viewNom2 = this.findViewById(R.id.nameUser);
            viewNom2.setText(neighbour.getName());

            TextView viewHabitation = this.findViewById(R.id.textViewLocation);
            viewHabitation.setText(neighbour.getAddress());

            TextView viewTel = this.findViewById(R.id.textViewTelephone);
            viewTel.setText(neighbour.getPhoneNumber());

            TextView textMedia = this.findViewById(R.id.textViewMedia);
            textMedia.setText("www.facebook.fr/"+neighbour.getName());

            TextView viewInfo = this.findViewById(R.id.textViewAProposDeMoi);
            viewInfo.setText(neighbour.getAboutMe());




            ImageView viewImage = this.findViewById(R.id.imageView);


            Glide.with(this)
                    .load(neighbour.getAvatarUrl())
                    .into(viewImage);




            FloatingActionButton boutonAddFavoris = findViewById(R.id.floatingActionButton);

            boutonAddFavoris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    // TODO
                    varPerso.addFavorisNeighbour(idUser);








                }
            });





        }

    }
}