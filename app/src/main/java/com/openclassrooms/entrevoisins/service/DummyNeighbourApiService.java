package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
 //   private ArrayList<Neighbour> listFavoris = new ArrayList<>();



//    public List<Integer> getFavorisNeighbours() {
//        return favorisNeighbours;
//    }

    //private List<Integer> favorisNeighbours = null ;





    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */

    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }



    public void delFavorisNeighbour(long idNeighbour){

        Neighbour neighbour = null;
        for (Neighbour y : neighbours) {
            if(y.getId() == idNeighbour)
                neighbour = y;
        }

        if(neighbour != null)
        {
            neighbour.setFavoris(false);//Swing
            //listFavoris.add(neighbour);
        }


    }


    @Override
    public void addFavorisNeighbour(long idNeighbour)
    {
        Neighbour neighbour = null;

        for (Neighbour n : neighbours) {
            if(n.getId() == idNeighbour)
                neighbour = n;
        }

        if(neighbour != null)
        {
            neighbour.setFavoris(true);//Swing
            //listFavoris.add(neighbour);
        }
    }


    @Override
    public ArrayList<Neighbour> getFavorisNeighbour()
    {
        ArrayList<Neighbour> listFavoris = new ArrayList<>();

        for (Neighbour n : neighbours) {
            if(n.isFavoris())
                listFavoris.add(n);
        }

        return listFavoris;
    }
}
