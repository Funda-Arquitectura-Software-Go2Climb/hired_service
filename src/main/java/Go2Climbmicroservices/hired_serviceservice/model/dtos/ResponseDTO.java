package Go2Climbmicroservices.hired_serviceservice.model.dtos;


import Go2Climbmicroservices.hired_serviceservice.model.entity.Hired_Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Hired_Service hired_service;
    //private ActivityDTO  activityDTO;
    //private CustomerDTO customerDTO;
    private ServiceDTO serviceDTO;
}
