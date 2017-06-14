package com.github.aprofromindia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Apro on 13-06-2017.
 */

@RepositoryRestResource
interface UserRepository extends CrudRepository<User, Long> {
}
