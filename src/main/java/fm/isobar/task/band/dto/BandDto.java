package fm.isobar.task.band.dto;

import fm.isobar.task.album.dto.AlbumDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BandDto {

  private String id;
  private String name;
  private String image;
  private String genre;
  private String biography;
  private Integer numPlays;
  private List<String> albums;
  private List<List<AlbumDto>> albumList;
}
