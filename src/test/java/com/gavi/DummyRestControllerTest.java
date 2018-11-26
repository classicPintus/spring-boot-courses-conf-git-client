package com.gavi;

import com.gavi.controller.DummyRestController;
import com.gavi.controller.CompleteClass;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DummyRestControllerTest {
    
    @MockBean
    private DummyRestController dummyRestController;

    @Test
    public void testTestFranco() {
        given(dummyRestController.testFranco()).willReturn("gianni");
        assertThat(dummyRestController.testFranco()).isEqualTo("gianni");
    }

    @Test
    public void testTestCompleteClass() {
        CompleteClass cc = new CompleteClass();
        given(dummyRestController.testCompleteClass()).willReturn(cc);
        assertThat(dummyRestController.testCompleteClass()).isEqualTo(cc);
    }
    
}
