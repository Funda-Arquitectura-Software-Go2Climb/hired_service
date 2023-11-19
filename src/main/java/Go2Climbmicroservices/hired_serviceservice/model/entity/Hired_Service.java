package Go2Climbmicroservices.hired_serviceservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "hired_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hired_Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int amount  ;
    private long price;
    private int status;
   // private Integer  activityId;
    private Integer  serviceId;
}
