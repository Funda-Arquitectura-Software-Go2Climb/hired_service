package Go2Climbmicroservices.hired_serviceservice.service;


import Go2Climbmicroservices.hired_serviceservice.model.dtos.ResponseDTO;
import Go2Climbmicroservices.hired_serviceservice.model.dtos.ServiceDTO;
import Go2Climbmicroservices.hired_serviceservice.model.entity.Hired_Service;
import Go2Climbmicroservices.hired_serviceservice.repository.Hired_ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
@AllArgsConstructor
public class Hired_ServiceService {

    private final Hired_ServiceRepository hired_serviceRepository;
    //inyeccion por constructor para la comunicacion entre microservicios
    //inyectamos Webclient para solicitudes HTTP para realizar llamadas a servicios web Restful
    //Reactiva y no bloqueante
    private final WebClient.Builder webClientBuilder;
    public Hired_Service saveHired_Service(Hired_Service hired_service){
        return hired_serviceRepository.save(hired_service);
    }
    public List<Hired_Service> fetchAll() {
        return hired_serviceRepository.findAll();
    }
    public  boolean deleteByIdHired_Service(Integer id) {
        if (hired_serviceRepository.existsById(id)) {
            hired_serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Mono<Hired_Service> findHired_ServiceById(Integer id) {
        return Mono.justOrEmpty(hired_serviceRepository.findById(id));
    }

    /*

    public Mono<ResponseDTO> getHired_ServiceById(Integer id) {
        Mono<Hired_Service> hiredServiceMono = hired_serviceRepository.findById(id)
                .map(Mono::just)
                .orElse(Mono.empty());

        return hiredServiceMono.flatMap(hired_service ->
                webClientBuilder.build().get()
                        .uri("http://localhost:8082/api/activities/{id}", hired_service.getActivityId())
                        .retrieve()
                        .bodyToMono(ActivityDTO.class)
                        .map(activityDTO -> {
                            ResponseDTO responseDTO = new ResponseDTO();
                            responseDTO.setHired_service(hired_service);
                            responseDTO.setActivityDTO(activityDTO);
                            return responseDTO;
                        })
        );
    }
*/
    public Mono<ResponseDTO> getService_ServiceById(Integer id){
        Mono<Hired_Service> hiredServiceMono = hired_serviceRepository.findById(id)
                .map(Mono::just)
                .orElse(Mono.empty());


        return hiredServiceMono.flatMap(hired_service ->
                webClientBuilder.build().get()
                        .uri("http://localhost:8081/api/v1/service/{id}", hired_service.getServiceId())
                        .retrieve()
                        .bodyToMono(ServiceDTO.class)
                        .map(serviceDTO -> {
                            ResponseDTO responseDTO = new ResponseDTO();
                            responseDTO.setHired_service(hired_service);
                            responseDTO.setServiceDTO(serviceDTO);
                            return responseDTO;
                        })
        );
    }


}
