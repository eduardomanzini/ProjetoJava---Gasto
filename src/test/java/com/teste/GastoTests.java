package com.teste;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.gastoDto.GastoDto;
import com.teste.service.GastoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GastoTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GastoService service;

    @Test
    public void getAllGastoAPI() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                        .get("/gastos")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getGastoByIdAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/gastos/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createGastoAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/gastos")
                        .content(asJsonString(new GastoDto("Joao", "Jantar", BigDecimal.valueOf(40.50), "Comida")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateGastoAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .put("/gastos/{id}", 2)
                        .content(asJsonString(new GastoDto("joao", "Almoco",BigDecimal.valueOf(70.50), "comida")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteGastoAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/gastos/{id}", 1) )
                .andExpect(status().isNoContent());
    }

}
