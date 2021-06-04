package dio.vacina.dto.mapper;

import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.entities.Vacina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VacinaMapper {

    @Mapping(target = "dataEnvio", source = "dataEnvio", dateFormat = "dd-MM-yyyy")
    Vacina toModel(VacinaDTO dto);

    VacinaDTO toDTO(Vacina dto);
}
