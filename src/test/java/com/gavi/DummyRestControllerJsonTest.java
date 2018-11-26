package com.gavi;

import com.gavi.controller.DummyRestController;
import com.gavi.controller.CompleteClass;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@RunWith(SpringRunner.class)
@JsonTest
public class DummyRestControllerJsonTest {
    
    @MockBean
    private DummyRestController dummyRestController;
    
    @Autowired
    private JacksonTester<String> jsonForStrings;
    
    @Autowired
    private JacksonTester<CompleteClass> jsonForCompleteClass;

    @Test
    public void testTestFranco() throws IOException {
        String expectedJson = "\"gianni\"";
        given(dummyRestController.testFranco()).willReturn("gianni");
        
        assertThat(jsonForStrings.write(dummyRestController.testFranco())).isEqualToJson(expectedJson);
    }

    @Test
    public void testTestCompleteClass() throws IOException {
        String expectedJson = "{\"number\":991.12345,\"string\":\"Alfa Romeo\",\"localDate\":\"1984-10-02\",\"localDateTime\":\"1992-02-06T01:02:03.000000004\",\"instant\":\"1970-01-01T00:00:00Z\",\"zonedDateTime\":\"1992-02-06T01:02:03.000000004Z\"}";
        
        CompleteClass res = new CompleteClass();
        final Instant instant = Instant.ofEpochSecond(0L);
        final LocalDate localDate = LocalDate.of(1984, Month.OCTOBER, 2);
        final LocalDateTime localDateTime = LocalDateTime.of(1992, Month.FEBRUARY, 6, 1, 2, 3, 4);
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("GMT"));
        res.setInstant(instant);
        res.setLocalDate(localDate);
        res.setLocalDateTime(localDateTime);
        res.setZonedDateTime(zonedDateTime);
        res.setNumber(new BigDecimal("991.12345"));
        res.setString("Alfa Romeo");
        
        given(dummyRestController.testCompleteClass()).willReturn(res);
        assertThat(jsonForCompleteClass.write(dummyRestController.testCompleteClass())).isEqualToJson(expectedJson);
    }
    
}
