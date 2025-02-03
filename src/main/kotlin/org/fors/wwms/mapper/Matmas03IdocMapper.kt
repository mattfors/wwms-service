package org.fors.wwms.mapper

    import org.fors.wwms.dto.MaterialDTO
    import org.fors.wwms.entity.Material
    import org.fors.wwms.idoc.Matmas03Idoc
    import org.mapstruct.Mapper
    import org.mapstruct.Mapping
    import org.mapstruct.factory.Mappers

    @Mapper
    interface Matmas03IdocMapper {
        companion object {
            val INSTANCE: Matmas03IdocMapper = Mappers.getMapper(Matmas03IdocMapper::class.java)
        }

        @Mapping(source = "E1MARAM.MATNR", target = "matNum")
        @Mapping(source = "E1MARAM.MTART", target = "materialType")
        //@Mapping(source = "e1maram.ean11", target = "upcCode")
        @Mapping(source = "E1MARAM.BRGEW", target = "weight")
        @Mapping(source = "E1MARAM.LAENG", target = "length")
        @Mapping(source = "E1MARAM.BREIT", target = "width")
        @Mapping(source = "E1MARAM.HOEHE", target = "height")

        @Mapping(source = "E1MKALM.TEXT1", target = "shortDesc")
        @Mapping(source = "E1MAKTM.MAKTX", target = "longDesc")
        @Mapping(source = "E1MARAM.SPART", target = "brandCode")
        fun matmas03IdocToMaterial(matmas03Idoc: Matmas03Idoc): MaterialDTO

    }