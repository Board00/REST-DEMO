package KAKRABA.REST_DEMO.controller;


import KAKRABA.REST_DEMO.model.SniperMastery;
import KAKRABA.REST_DEMO.response.ResponseHandler;
import KAKRABA.REST_DEMO.servive.SniperMasteryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/SNIPERS")
public class SniperMasteryController
{

    //    SniperMastery sniperMastery;
    SniperMasteryService sniperMasteryService;
    public SniperMasteryController(SniperMasteryService sniperMasteryService) {
        this.sniperMasteryService = sniperMasteryService;
    }
    @GetMapping("/{sniperId}")
    @ApiOperation(value ="Sniper Mastery id", notes="Provide sniper mastery details",
            response = ResponseEntity.class)
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("sniperId") String sniperId)
    {
        return ResponseHandler.responseBuilder("Requested Sniper Details are given here",
                HttpStatus.OK, sniperMasteryService.getSniperMastery(sniperId));
    }

    //read all
    @GetMapping("/")
    public List<SniperMastery> getAllSniperMasteryDetails()
    {
        return sniperMasteryService.getAllSniperMastery();
    }


    @PostMapping("/")
    public String createSniperMasteryDetails(@RequestBody SniperMastery sniperMastery)
    {
        sniperMasteryService.createSniperMastery(sniperMastery);
        return "Sniper Details Created Successfully";
    }

    @PutMapping("/")
    public String updateSniperMasteryDetails(@RequestBody SniperMastery sniperMastery)
    {
       sniperMasteryService.updateSniperMastery(sniperMastery);
        return "Sniper Details Updated Successfully";
    }

    @DeleteMapping("/{sniperId}")
    public String deleteSniperMasteryDetails(@PathVariable("sniperId") String sniperId)
    {
        sniperMasteryService.deleteSniperMastery(sniperId);
        return "Sniper Details Deleted Successfully";
    }
}
