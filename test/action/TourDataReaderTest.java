package action;

import com.epam.training.second.action.TourDataReaderFromFile;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TourDataReaderTest {
    @Test
    public void dataReader() {
        assertFalse(TourDataReaderFromFile.readTourDataFromFile("./data/tours.txt").isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void wrongFileReader() {
        TourDataReaderFromFile.readTourDataFromFile("wrong file path");
    }
}
