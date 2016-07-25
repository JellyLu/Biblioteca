package model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class MovieTest {
    @Test
    public void should_return_right_description(){
        Movie movie = new Movie("M_0001", "Test Movie Name", "Director Lu", 2016, 9);
        assertThat(movie.description(), is("[id]: M_0001, [name]: Test Movie Name, [director]: Director Lu, [year]: 2016, [rating]: 9"));
    }
}
