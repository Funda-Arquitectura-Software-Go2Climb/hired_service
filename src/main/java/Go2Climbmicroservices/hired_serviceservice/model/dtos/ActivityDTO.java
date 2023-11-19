package Go2Climbmicroservices.hired_serviceservice.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
    private Integer id;
    private String name;
    private String description;
    private  Integer hiredServiceId;
}
