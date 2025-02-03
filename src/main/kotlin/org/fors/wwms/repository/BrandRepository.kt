package org.fors.wwms.repository

import org.fors.wwms.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface BrandRepository : JpaRepository<Brand, Int>