package com.gavi;

import com.gavi.repository.CarModelRepository;
import com.gavi.entity.CarModel;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CarModelRepositoryTest {
    
    @Autowired
    private CarModelRepository carModelRepository;

    @Test
    public void testSomeMethod() {
        List<CarModel> models = carModelRepository.getModelsByManufacturer(1L);
        Assert.assertTrue(models.size() == 4);
    }
    
}
