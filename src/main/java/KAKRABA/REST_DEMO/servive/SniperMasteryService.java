package KAKRABA.REST_DEMO.servive;

import KAKRABA.REST_DEMO.model.SniperMastery;
import java.util.List;

public interface SniperMasteryService
{
    public String createSniperMastery(SniperMastery sniperMastery);
    public String updateSniperMastery(SniperMastery sniperMastery);
    public String deleteSniperMastery(String sniperId);
    public SniperMastery getSniperMastery(String sniperId);
    public List<SniperMastery> getAllSniperMastery();
    public List<SniperMastery> getBySniperName(String sniperName);
}
