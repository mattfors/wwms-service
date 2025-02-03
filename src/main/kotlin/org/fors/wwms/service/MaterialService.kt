package org.fors.wwms.service

import org.fors.wwms.dto.MaterialDTO
import org.fors.wwms.entity.Material
import org.fors.wwms.idoc.Matmas03Idoc
import org.fors.wwms.mapper.Matmas03IdocMapper
import org.fors.wwms.repository.MaterialRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MaterialService @Autowired constructor(
    private val materialRepository: MaterialRepository
) {

    val converter = Mappers.getMapper(Matmas03IdocMapper::class.java)

    fun convertIdocToMaterial(matmas03Idoc: Matmas03Idoc): Material {
        val dto = convertIdocToMaterialDTO(matmas03Idoc);
        /**
         * Presumably there would be some business logic performing different mappings
         * between the DTO and the entity depending on the context.
         */
        return convertMaterialDTOToMaterial(dto);
    }

    fun convertIdocToMaterialDTO(matmas03Idoc: Matmas03Idoc): MaterialDTO =
        converter.matmas03IdocToMaterial(matmas03Idoc)

    fun convertMaterialDTOToMaterial(materialDTO: MaterialDTO): Material =
        converter.materialDTOToMaterial(materialDTO)

    fun saveMaterial(matmas03Idoc: Matmas03Idoc): Material =
        materialRepository.save(convertIdocToMaterial(matmas03Idoc))

    fun saveMaterial(material: Material): Material =
        materialRepository.save(material)
}