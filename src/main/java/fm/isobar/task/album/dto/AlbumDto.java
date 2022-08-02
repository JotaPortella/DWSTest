package fm.isobar.task.album.dto;

import fm.isobar.task.track.dto.TrackDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto implements Serializable {
  private String id;
  private String name;
  private String image;
  private LocalDateTime releasedDate;
  private String band;
  private List<TrackDto> tracks;
}
