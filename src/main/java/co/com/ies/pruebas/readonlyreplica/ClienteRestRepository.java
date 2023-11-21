package co.com.ies.pruebas.readonlyreplica;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClienteRestRepository extends PagingAndSortingRepository<ClientEntity, Long> {

}
