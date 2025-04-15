package KAKRABA.REST_DEMO.servive.impl;

import KAKRABA.REST_DEMO.model.SniperMastery;
import KAKRABA.REST_DEMO.repository.SniperMasteryRepository;
import KAKRABA.REST_DEMO.servive.SniperMasteryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SniperMasteryServiceImplTest {

    @Mock
    private SniperMasteryRepository sniperMasteryRepository;
    private SniperMasteryService sniperMasteryService;
    AutoCloseable autoCloseable;
    SniperMastery sniperMastery;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        sniperMasteryService = new SniperMasteryServiceImpl(sniperMasteryRepository);
        sniperMastery = new SniperMastery("001", "Sniper1",
                "Earth", "unknown number");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void TestCreateSniperMastery() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class);

        when(sniperMasteryRepository.save(sniperMastery)).thenReturn(sniperMastery);
        assertThat(sniperMasteryService.createSniperMastery(sniperMastery))
                .isEqualTo("SUCCESS");
    }

    @Test
    void TestUpdateSniperMastery() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class);

        when(sniperMasteryRepository.save(sniperMastery)).thenReturn(sniperMastery);
        assertThat(sniperMasteryService.updateSniperMastery(sniperMastery))
                .isEqualTo("SUCCESS");

    }

    @Test
    void TestGetSniperMastery() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class);

        when(sniperMasteryRepository.findById("001"))
                .thenReturn(Optional.ofNullable(sniperMastery));
        assertThat(sniperMasteryService.getSniperMastery("001").getSniperName())
                .isEqualTo(sniperMastery.getSniperName());
    }

    @Test
    void TestGetBySniperName() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class);

        when(sniperMasteryRepository.findBySniperName("Sniper1")).
                thenReturn(new ArrayList<SniperMastery>(Collections.singleton(sniperMastery)));

        assertThat(sniperMasteryService.getBySniperName("Sniper1").get(0).getSniperId()).
                isEqualTo(sniperMastery.getSniperId());
    }

    @Test
    void TestGetAllSniperMastery() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class);

        when(sniperMasteryRepository.findAll()).
                thenReturn(new ArrayList<SniperMastery>(Collections.singleton(sniperMastery)));
        assertThat(sniperMasteryService.getAllSniperMastery().get(0).getSniperId())
                .isEqualTo(sniperMastery.getSniperId());
    }

    @Test
    void TestDeleteSniperMastery() {
        mock(SniperMastery.class);
        mock(SniperMasteryRepository.class, Mockito.CALLS_REAL_METHODS);

        when(sniperMasteryRepository.findById("001")).thenReturn(Optional.of(sniperMastery));
        when(sniperMasteryRepository.existsById("001")).thenReturn(false);
        assertThat(sniperMasteryService.deleteSniperMastery("001"))
                .isEqualTo("SUCCESS");
    }

}