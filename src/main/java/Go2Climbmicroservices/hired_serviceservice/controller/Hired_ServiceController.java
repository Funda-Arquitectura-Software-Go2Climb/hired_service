package Go2Climbmicroservices.hired_serviceservice.controller;


import Go2Climbmicroservices.hired_serviceservice.model.dtos.ResponseDTO;
import Go2Climbmicroservices.hired_serviceservice.model.entity.Hired_Service;
import Go2Climbmicroservices.hired_serviceservice.service.Hired_ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/api/hired_services")
@AllArgsConstructor
public class Hired_ServiceController {
    private final Hired_ServiceService hired_serviceService;

    @PostMapping
    public Hired_Service saveHired_Service(@RequestBody Hired_Service hired_service){
        return hired_serviceService.saveHired_Service(hired_service);
    }

    @GetMapping
    public List<Hired_Service> fetchAll() {
        return hired_serviceService.fetchAll();
    }

    @GetMapping("/{id}/hired-service")
    public Mono<ResponseEntity<Hired_Service>> getHiredServiceById(@PathVariable Integer id) {
        return hired_serviceService.findHired_ServiceById(id)
                .map(hiredService -> ResponseEntity.ok().body(hiredService))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }




    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(hired_serviceService.deleteByIdHired_Service(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

/*
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ResponseDTO>> getHired_ServiceById(@PathVariable Integer id) {
        return hired_serviceService.getHired_ServiceById(id)
                .map(responseDTO -> ResponseEntity.ok(responseDTO)) // Envoltura de la respuesta en un ResponseEntity con estado 200 OK
                .defaultIfEmpty(ResponseEntity.notFound().build()); // Respuesta 404 Not Found si el Mono está vacío
    }

*/
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ResponseDTO>> getService_ServiceById(@PathVariable Integer id){
        return hired_serviceService.getService_ServiceById(id)
                .map(responseDTO -> ResponseEntity.ok(responseDTO)); // Envoltura de la respuesta en un ResponseEntity con estado 200 OK

    }



}
