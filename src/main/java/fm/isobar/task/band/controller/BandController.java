package fm.isobar.task.band.controller;

import fm.isobar.task.album.service.AlbumService;
import fm.isobar.task.band.dto.BandDto;
import fm.isobar.task.band.dto.BandDtoList;
import fm.isobar.task.band.dto.BandFilter;
import fm.isobar.task.band.service.BandService;
import fm.isobar.task.track.dto.TrackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/band")
public class BandController {

  @Autowired private BandService bandService;
  @Autowired private AlbumService albumService;

  @GetMapping("select")
  public List<BandDtoList> getAll(@RequestBody BandFilter bandFilter) {
    return bandService.getAll(bandFilter);
  }

  @GetMapping
  public BandDto getBandById(@RequestBody String bandId) {
    return bandService.getBandById(bandId);
  }

  @GetMapping("album/track")
  public List<TrackDto> getTrackListByAlbumId(@RequestBody String albumId) {
    return albumService.getTrackListByAlbumId(albumId);
  }
}
