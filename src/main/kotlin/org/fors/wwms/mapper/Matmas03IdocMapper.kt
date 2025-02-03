package org.fors.wwms.mapper

import org.fors.wwms.dto.MaterialDTO
import org.fors.wwms.entity.Material
import org.fors.wwms.idoc.Matmas03Idoc
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface Matmas03IdocMapper {

    /*@Mapping(source = "e1MARAM.MATNR", target = "matNum")
    @Mapping(source = "e1MARAM.MTART", target = "materialType")
    @Mapping(source = "e1MARAM.BRGEW", target = "weight")
    @Mapping(source = "e1MARAM.LAENG", target = "length")
    @Mapping(source = "e1MARAM.BREIT", target = "width")
    @Mapping(source = "e1MARAM.HOEHE", target = "height")
    @Mapping(source = "e1MKALM.TEXT1", target = "shortDesc")
    @Mapping(source = "e1MAKTM.MAKTX", target = "longDesc")
    @Mapping(source = "e1MARAM.SPART", target = "brandCode")*/
    fun matmas03IdocToMaterial(matmas03Idoc: Matmas03Idoc): MaterialDTO

    @Mapping(source = "matNum", target = "matNum")
    @Mapping(source = "materialType", target = "materialType")
    @Mapping(source = "weight", target = "dimension.weight")
    @Mapping(source = "length", target = "dimension.length")
    @Mapping(source = "width", target = "dimension.width")
    @Mapping(source = "height", target = "dimension.height")
    @Mapping(source = "shortDesc", target = "description.shortDesc")
    @Mapping(source = "longDesc", target = "description.longDesc")
    @Mapping(source = "brandCode", target = "brandCode")
    fun materialDTOToMaterial(materialDTO: MaterialDTO): Material
}