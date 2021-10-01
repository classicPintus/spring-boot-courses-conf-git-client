package com.gavi;

import com.gavi.controller.CompleteClass;
import com.gavi.controller.DummyRestController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

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
