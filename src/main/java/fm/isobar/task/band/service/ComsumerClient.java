package fm.isobar.task.band.service;

import fm.isobar.task.band.dto.BandDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
    value = "bandService",
    url = "https://iws-brazil-labs-iws-recruiting-bands-staging.iwsbrazil.io/api/full")
public interface ComsumerClient {

  @GetMapping
  List<BandDto> getAllBands();
}
