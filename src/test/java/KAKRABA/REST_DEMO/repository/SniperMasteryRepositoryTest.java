package KAKRABA.REST_DEMO.repository;


import KAKRABA.REST_DEMO.model.SniperMastery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SniperMasteryRepositoryTest
{
    @Autowired
    private SniperMasteryRepository sniperMasteryRepository;
    SniperMastery sniperMastery;

    @BeforeEach
    void setUp() {
        sniperMastery = new SniperMastery("001", "Sniper1",
                "Earth", "unknown number");

        sniperMasteryRepository.save(sniperMastery);
    }

    @AfterEach
    void tearDown() {
        sniperMastery = null;
        sniperMasteryRepository.deleteAll();
    }

    // Test for findBySniperName method
    // Test case Success
    @Test
    void testFindBySniperName_Found()
    {
        List<SniperMastery> sniperMasteryList = sniperMasteryRepository.findBySniperName("Sniper1");
        assertThat(sniperMasteryList.get(0).getSniperId()).isEqualTo(sniperMastery.getSniperId());

        assertThat(sniperMasteryList.get(0).getSniperName()).isEqualTo(sniperMastery.getSniperName());
    }
    // Test case Failure
    @Test
    void testFindBySniperName_NotFound()
    {
        List<SniperMastery> sniperMasteryList = sniperMasteryRepository.findBySniperName("Sniper2");
        assertThat(sniperMasteryList.isEmpty()).isTrue();
    }
}
