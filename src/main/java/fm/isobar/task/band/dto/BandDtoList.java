package fm.isobar.task.band.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BandDtoList {

  private String id;
  private String name;
  private String image;
  private String genre;
  private Integer numPlays;

  public static BandDtoList of(BandDto bandDto) {
    return BandDtoList.builder()
        .id(bandDto.getId())
        .name(bandDto.getName())
        .image(bandDto.getImage())
        .genre(bandDto.getGenre())
        .numPlays(bandDto.getNumPlays())
        .build();
  }
}
