package KAKRABA.REST_DEMO.controller;

import KAKRABA.REST_DEMO.model.SniperMastery;
import KAKRABA.REST_DEMO.servive.SniperMasteryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@WebMvcTest(SniperMasteryController.class)
class SniperMasteryControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private SniperMasteryService sniperMasteryService;
    SniperMastery sniperMasteryOne;
    SniperMastery sniperMasteryTwo;
    List<SniperMastery> sniperMasteryList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        sniperMasteryOne = new SniperMastery("001", "Sniper1",
                "Earth", "Unknown Number");
        sniperMasteryTwo = new SniperMastery("002", "Sniper2",
                "Earth", "Unknown Number");
        sniperMasteryList.add(sniperMasteryOne);
        sniperMasteryList.add(sniperMasteryTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestGetSniperMasteryDetails() throws Exception {
        when(sniperMasteryService.getSniperMastery("001"))
                .thenReturn(sniperMasteryOne);
        this.mockMvc.perform(get("/SNIPERS/" + "001"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestGetAllSniperMasteryDetails() throws Exception {
        when(sniperMasteryService.getAllSniperMastery())
                .thenReturn(sniperMasteryList);
        this.mockMvc.perform(get("/SNIPERS"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestCreateSniperMasteryDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(sniperMasteryOne);

        when(sniperMasteryService.createSniperMastery(sniperMasteryOne)).thenReturn("Success");
        this.mockMvc.perform(post("/SNIPERS")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestUpdateSniperMasteryDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(sniperMasteryOne);

        when(sniperMasteryService.updateSniperMastery(sniperMasteryOne))
                .thenReturn("Sniper Details Updated Successfully");
        this.mockMvc.perform(put("/SNIPERS")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestDeleteSniperMasteryDetails() throws Exception{
        when(sniperMasteryService.deleteSniperMastery("001"))
                .thenReturn("Sniper Details Deleted Successfully");
        this.mockMvc.perform(delete("/SNIPERS/" + "001"))
                .andDo(print()).andExpect(status().isOk());
    }
}