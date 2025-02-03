package org.fors.wwms.mapper

import jakarta.annotation.PostConstruct
import org.fors.wwms.dto.MaterialDTO
import org.fors.wwms.idoc.Matmas03Idoc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.modelmapper.ModelMapper
/*
@Component
class ModelMapperConfig @Autowired constructor(private val modelMapper: ModelMapper) {

    @PostConstruct
    fun configureMappings() {
        modelMapper.typeMap(Matmas03Idoc::class.java, MaterialDTO::class.java).apply {
            addMappings {
                it.map(Matmas03Idoc::E1MARAM.MATNR, MaterialDTO::matNum)
                it.map(Matmas03Idoc::E1MARAM.MTART, MaterialDTO::materialType)
                it.map(Matmas03Idoc::E1MARAM.BRGEW, MaterialDTO::weight)
                it.map(Matmas03Idoc::E1MARAM.LAENG, MaterialDTO::length)
                it.map(Matmas03Idoc::E1MARAM.BREIT, MaterialDTO::width)
                it.map(Matmas03Idoc::E1MARAM.HOEHE, MaterialDTO::height)
                it.map(Matmas03Idoc::E1MKALM.TEXT1, MaterialDTO::shortDesc)
                it.map(Matmas03Idoc::E1MAKTM.MAKTX, MaterialDTO::longDesc)
                it.map(Matmas03Idoc::E1MARAM.SPART, MaterialDTO::brandCode)
            }
        }
    }
}*/