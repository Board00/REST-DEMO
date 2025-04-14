package KAKRABA.REST_DEMO.servive.impl;

import KAKRABA.REST_DEMO.model.SniperMastery;
import KAKRABA.REST_DEMO.repository.SniperMasteryRepository;
import KAKRABA.REST_DEMO.servive.SniperMasteryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SniperMasteryServiceImpl implements SniperMasteryService
{
    SniperMasteryRepository sniperMasteryRepository;

    public SniperMasteryServiceImpl(SniperMasteryRepository sniperMasteryRepository) {
        this.sniperMasteryRepository = sniperMasteryRepository;
    }


    @Override
    public String createSniperMastery(SniperMastery sniperMastery)
    {
        // more validation can be added here
        sniperMasteryRepository.save(sniperMastery);
        return "SUCCESS";
    }

    @Override
    public String updateSniperMastery(SniperMastery sniperMastery)
    {
        // more validation can be added here
        sniperMasteryRepository.save(sniperMastery);
        return "SUCCESS";
    }

    @Override
    public String deleteSniperMastery(String sniperId)
    {
        // more validation can be added here
         sniperMasteryRepository.deleteById(sniperId);
        return "SUCCESS";
    }

    @Override
    public SniperMastery getSniperMastery(String sniperId)
    {
        // more validation can be added here
        return sniperMasteryRepository.findById(sniperId).get();
    }

    @Override
    public List<SniperMastery> getAllSniperMastery()
    {
        // more validation can be added here
        return sniperMasteryRepository.findAll();
    }
}
