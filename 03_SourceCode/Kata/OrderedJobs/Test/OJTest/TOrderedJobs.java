package OJTest;

import OrderedJobs.OrderedJobs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TOrderedJobs {
    @Test
    public void ItshouldReturnAGivenA()
    {
        //arrange
        var sut_ = new OrderedJobs();
        sut_.registerJob("A");
        //act
        sut_.sort();
        //assert
        assertEquals("A",sut_.getList());
    }

    @Test
    void ItshouldReturnABgivenAB() {
        //arrange
        var sut_ = new OrderedJobs();
        sut_.registerJob("A");
        sut_.registerJob("B");
        //act
        sut_.sort();
        //assert
        assertEquals("AB",sut_.getList());
    }

    @Test
    void ItShouldReturnABCgivenABC() {
        //arrange
        var sut_ = new OrderedJobs();
        sut_.registerJob("A");
        sut_.registerJob("B");
        sut_.registerJob("C");
        //act
        sut_.sort();
        //assert
        assertEquals("ABC",sut_.getList());
    }

    @Test
    void ItShouldReturnABgivenBdebendsOnA() {
        //arrange
        var sut_ = new OrderedJobs();
        sut_.registerJob("B","A");

        sut_.sort();

        assertEquals("AB", sut_.getList());
    }

    @Test
    void ItShouldReturnABCGivenCDependsOnBAndBDependsOnC() {
        //arrange
        var sut_ = new OrderedJobs();
        sut_.registerJob("B","A");
        sut_.registerJob("C","B");

        sut_.sort();

        assertEquals("ABC", sut_.getList());
    }

    @Test
    void ItShouldReturnABGivenABB() {
        var sut_ = new OrderedJobs();
        sut_.registerJob("A");
        sut_.registerJob("B");
        sut_.registerJob("B");

        sut_.sort();

        assertEquals("AB", sut_.getList());
    }

    @Test
    void ItShouldReturnABCGivenDdependsOnBandBdependsOnC() {
        var sut_ = new OrderedJobs();
        sut_.registerJob("C","B");
        sut_.registerJob("B","A");

        sut_.sort();

        assertEquals("ABC", sut_.getList());
    }

    @Test
    void ItShoudReturnBA_GivenBAUsingSort() {
        var sut_ = new OrderedJobs();
        sut_.registerJob("B");
        sut_.registerJob("A");

        sut_.sort();

        assertEquals("BA", sut_.getList());
    }
}
