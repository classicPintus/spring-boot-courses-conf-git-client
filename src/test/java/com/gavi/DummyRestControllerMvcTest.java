package com.gavi;

import com.gavi.controller.DummyRestController;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(DummyRestController.class)
public class DummyRestControllerMvcTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private DummyRestController dummyRestController;

    @Test
    public void testTestFranco() throws Exception {
        given(dummyRestController.testFranco()).willReturn("gianni");
        
        mvc.perform(MockMvcRequestBuilders.get("/testFranco")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("gianni"));
    }
    
}
