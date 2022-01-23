package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);

        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    //ajout de favoris
    //recuperation de favoris

    @Test
    public void deleteFromFavoris()
    {
        Neighbour delFavorisNeighnour = service.getNeighbours().get(0);

        delFavorisNeighnour.setFavoris(false);

        assertFalse(delFavorisNeighnour.isFavoris());
        //assertEquals(false, delFavorisNeighnour.isFavoris());
    }

    @Test
    public void addFavoris(){
        Neighbour UserFavoris = service.getNeighbours().get(0);
        UserFavoris.setFavoris(true);
        assertEquals(true, UserFavoris.isFavoris());

    }

    @Test
    public void getFavoris(){

        Neighbour getUserFavoris = service.getNeighbours().get(0);


        DummyNeighbourApiService neighbourApiService = new DummyNeighbourApiService();

        getUserFavoris.setFavoris(true);

       neighbourApiService.addFavorisNeighbour(getUserFavoris.getId());

        assertEquals(true,getUserFavoris.isFavoris() );

    }

}
