package co.com.ies.pruebas.readonlyreplica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(peopleService.get());
    }
}
