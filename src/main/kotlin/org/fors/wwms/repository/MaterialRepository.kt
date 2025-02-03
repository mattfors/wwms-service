package org.fors.wwms.repository

import org.fors.wwms.entity.Material
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaterialRepository : JpaRepository<Material, Int>