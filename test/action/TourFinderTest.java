package action;

import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.action.TourFinder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.type.Destination;
import com.epam.training.second.entity.type.Food;
import com.epam.training.second.entity.type.Goal;
import com.epam.training.second.entity.type.Transportation;
import com.epam.training.second.exception.WrongTourException;
import com.epam.training.second.factory.TourFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TourFinderTest {
    static TourFactory lavanda = new TourFactory();
    static Agency lavandaLand = new Agency("Lavanda Land");

    @BeforeClass
    public static void addTours() {
        lavandaLand.getTours().addAll(TourCreatorFromFile.createToursFromFile("./data/tours.txt", lavanda));
    }

    @Test
    public void findByNameTest() throws WrongTourException {
        assertEquals(TourFinder.findTour(lavandaLand, "coldplay").getTourName(), "coldplay");
    }

    @Test
    public void findByGoal() throws WrongTourException {
        assertEquals(TourFinder.findTour(lavandaLand, Goal.FESTIVAL).get(0).getGoal(), Goal.FESTIVAL);
    }

    @Test
    public void findByDateAndDestination() throws WrongTourException {
        assertEquals(TourFinder.findTour(lavandaLand, "2016-01-01", Destination.POLAND).get(0).getDestination(), Destination.POLAND);
    }

    @Test
    public void findByDurationFoodAndTransportation() throws WrongTourException {
        assertEquals(TourFinder.findTour(lavandaLand, 19, Food.WHOLE_DAY, Transportation.PLANE).get(0).getTourName(), "food & spa");
    }

}