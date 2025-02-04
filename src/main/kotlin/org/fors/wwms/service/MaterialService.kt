package org.fors.wwms.service

import org.fors.wwms.dto.MaterialDTO
import org.fors.wwms.entity.Material
import org.fors.wwms.repository.MaterialRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MaterialService @Autowired constructor(
    private val materialRepository: MaterialRepository
) {


    fun saveMaterial(material: Material): Material =
        materialRepository.save(material)
}