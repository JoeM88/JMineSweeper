import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by josephmolina on 6/16/17.
 */
public class TileTests {
    private Tile tile = new Tile(3, "X", false);

    @Test
    public void getNumOfBombs() throws Exception{
        assertEquals(3, tile.getNumBombsNearBy());
    }



}


