package fm.isobar.task.album.service;

import fm.isobar.task.band.service.ComsumerClient;
import fm.isobar.task.track.dto.TrackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AlbumService {

  private final ComsumerClient comsumerClient;

  public List<TrackDto> getTrackListByAlbumId(String albumId) {
    return comsumerClient.getAllBands().stream()
        .flatMap(band -> band.getAlbumList().stream())
        .flatMap(Collection::stream)
        .filter(album -> album.getId().equals(albumId))
        .flatMap(album -> album.getTracks().stream())
        .toList();
  }
}
