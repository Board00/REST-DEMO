package KAKRABA.REST_DEMO.repository;

import KAKRABA.REST_DEMO.model.SniperMastery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SniperMasteryRepository extends JpaRepository<SniperMastery, String>
{
    List<SniperMastery> findBySniperName(String sniperName);
}
