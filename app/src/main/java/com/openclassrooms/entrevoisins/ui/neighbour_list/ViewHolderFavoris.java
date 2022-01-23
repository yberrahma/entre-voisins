package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolderFavoris extends RecyclerView.ViewHolder {

    @BindView(R.id.item_list_avatar)
    TextView textView;

    public ViewHolderFavoris(@NonNull View itemView) {
        super(itemView);
//textView = itemView.findViewById(R.id.fragment_main_item_title);

    }

//    public GithubUserViewHolder(View itemView) {
//        super(itemView);
//        ButterKnife.bind(this, itemView);
//
//    }

//    public void updateWithGithubUser(GithubUser githubUser){
//        this.textView.setText(githubUser.getLogin());
//    }



}
