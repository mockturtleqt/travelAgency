package action;

import com.epam.training.second.action.TourBooker;
import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Client;
import com.epam.training.second.factory.TourFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TourBookerTest {
    static TourFactory lavanda = new TourFactory();
    static Agency lavandaLand = new Agency("Lavanda Land");
    static Client galia = new ClientBuilder("Mock", "Turtle", 123).build();

    @BeforeClass
    public static void addTours() {
        lavandaLand.getTours().addAll(TourCreatorFromFile.createToursFromFile("./data/tours.txt", lavanda));
    }

    @Test
    public void tourBookerTest() {
        assertTrue(galia.getBookings().isEmpty());
        TourBooker.bookTour(lavandaLand, galia, "coldplay");
        assertFalse(galia.getBookings().isEmpty());
    }

}
