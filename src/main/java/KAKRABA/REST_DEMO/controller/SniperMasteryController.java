package KAKRABA.REST_DEMO.controller;


import KAKRABA.REST_DEMO.model.SniperMastery;
import KAKRABA.REST_DEMO.servive.SniperMasteryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SNIPERS")
public class SniperMasteryController
{

    //    SniperMastery sniperMastery;
    SniperMasteryService sniperMasteryService;
    public SniperMasteryController(SniperMasteryService sniperMasteryService) {
        this.sniperMasteryService = sniperMasteryService;
    }
    //Read one
    @GetMapping("{sniperId}")
    public SniperMastery getSniperMasteryDetails(@PathVariable("sniperId") String sniperId)
    {
        return sniperMasteryService.getSniperMastery(sniperId);
    }
    //read all
    @GetMapping()
    public List<SniperMastery> getAllSniperMasteryDetails()
    {
        return sniperMasteryService.getAllSniperMastery();
    }


    @PostMapping
    public String createSniperMasteryDetails(@RequestBody SniperMastery sniperMastery)
    {
        sniperMasteryService.createSniperMastery(sniperMastery);
        return "Sniper Details Created Successfully";
    }

    @PutMapping
    public String updateSniperMasteryDetails(@RequestBody SniperMastery sniperMastery)
    {
       sniperMasteryService.updateSniperMastery(sniperMastery);
        return "Sniper Details Updated Successfully";
    }

    @DeleteMapping("{sniperId}")
    public String deleteSniperMasteryDetails(@PathVariable("sniperId") String sniperId)
    {
        sniperMasteryService.deleteSniperMastery(sniperId);
        return "Sniper Details Deleted Successfully";
    }
}
