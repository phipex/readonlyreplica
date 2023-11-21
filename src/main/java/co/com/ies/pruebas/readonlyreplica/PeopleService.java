package co.com.ies.pruebas.readonlyreplica;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PeopleService {

    private final PersonRepository personRepository;


    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> get(){
        Iterable<Person> all = personRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());

    }
}
