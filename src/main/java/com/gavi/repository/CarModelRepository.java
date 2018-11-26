package com.gavi.repository;

import com.gavi.entity.CarModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarModelRepository extends PagingAndSortingRepository<CarModel, Long> {
    @Query("from CarModel cm where cm.carManufacturer.id = ?1")
    List<CarModel> getModelsByManufacturer(Long cmId);
}
