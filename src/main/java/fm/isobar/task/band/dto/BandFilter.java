package fm.isobar.task.band.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BandFilter {

  private String name;
  private boolean popularity = false;
  private boolean alphabeticalOrder = false;
}
