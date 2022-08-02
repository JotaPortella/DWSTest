package fm.isobar.task.band.service;

import fm.isobar.task.band.dto.BandDto;
import fm.isobar.task.band.dto.BandDtoList;
import fm.isobar.task.band.dto.BandFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BandService {

  @Autowired private ComsumerClient comsumerClient;

  public List<BandDtoList> getAll(BandFilter bandFilter) {
    List<BandDto> bandDto = comsumerClient.getAllBands();

    if (bandFilter.isAlphabeticalOrder()) {
      bandDto =
          bandDto.stream()
              .sorted(Comparator.comparing(BandDto::getName))
              .collect(Collectors.toList());
    }

    if (bandFilter.isPopularity()) {
      bandDto =
          bandDto.stream()
              .sorted(Comparator.comparingInt(BandDto::getNumPlays))
              .collect(Collectors.toList());
    }

    if (!ObjectUtils.isEmpty(bandFilter.getName())) {
      bandDto =
          bandDto.stream()
              .filter(band -> band.getName().contains(bandFilter.getName()))
              .collect(Collectors.toList());
    }

    return bandDto.stream().map(BandDtoList::of).collect(Collectors.toList());
  }

  public BandDto getBandById(String bandId) {
    return comsumerClient.getAllBands().stream()
        .filter(band -> bandId.equals(band.getId()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Band does not exist in the database"));
  }
}
