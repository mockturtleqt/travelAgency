import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.factory.TourFactory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TourCreatorFromFileTest {
    TourFactory tourFactory = new TourFactory();

    @Test
    public void tourCreationTest() {
        assertFalse(TourCreatorFromFile.createToursFromFile("./data/tours.txt", tourFactory).isEmpty());
    }
}
