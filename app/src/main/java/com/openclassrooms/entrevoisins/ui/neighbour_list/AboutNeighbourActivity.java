package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;

import java.io.Serializable;


public class AboutNeighbourActivity extends AppCompatActivity {


    public DummyNeighbourApiService neighbourApiService;
    //private int idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_neighbour);




        neighbourApiService = new DummyNeighbourApiService();





        Intent intent = this.getIntent();

        Serializable ser = intent.getSerializableExtra("test");

        Neighbour neighbour = null;

        if(ser instanceof Neighbour)
        {
            neighbour = (Neighbour) ser;


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






            Neighbour finalNeighbour = neighbour;


            //Pour bouton
            if(finalNeighbour.isFavoris() == false) {
                boutonAddFavoris.setImageDrawable(getDrawable(R.drawable.non_favoris));
            }else {boutonAddFavoris.setImageDrawable(getDrawable(R.drawable.favoris));}



            boutonAddFavoris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (finalNeighbour.isFavoris() == false) {

                        boutonAddFavoris.setImageDrawable(getDrawable(R.drawable.favoris));
                        neighbourApiService.addFavorisNeighbour(finalNeighbour.getId());
                    }
                    else {
                        boutonAddFavoris.setImageDrawable(getDrawable(R.drawable.non_favoris));
                        neighbourApiService.delFavorisNeighbour(finalNeighbour.getId());

                    }
                    //boutonAddFavoris.setImageDrawable();


                   //ContextCompat.getDrawable(context, R.drawable.ready)
                    //ContextCompat.getDrawable(AboutNeighbourActivity.this,R.drawable.ic_launcher_background);
                }
            });





        }

    }
}