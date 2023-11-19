package Go2Climbmicroservices.hired_serviceservice.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String photo;
}
