package id.co.mii.LMS.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Segment {
    private Integer id;
    private String title;
    private LocalDate start_date;
    private LocalDate end_date;
    private String description;
}
