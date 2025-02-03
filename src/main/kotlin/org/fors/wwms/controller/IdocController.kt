package org.fors.wwms.controller

import org.fors.wwms.dto.MaterialDTO
import org.fors.wwms.entity.Material
import org.fors.wwms.idoc.Matmas03Idoc
import org.fors.wwms.service.MaterialService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/idoc/")
class IdocController(private val materialService: MaterialService) {

    @PostMapping(
        "matmas03/convert/material",
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    fun convertIdocToMaterial(@RequestBody matmas03Idoc: Matmas03Idoc): ResponseEntity<Material> =
        ResponseEntity.ok(materialService.convertIdocToMaterial(matmas03Idoc))

    @PostMapping(
        "matmas03/convert/materialdto",
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    fun convertIdocToMaterialDTO(@RequestBody matmas03Idoc: Matmas03Idoc): ResponseEntity<MaterialDTO> =
        ResponseEntity.ok(materialService.convertIdocToMaterialDTO(matmas03Idoc))
}