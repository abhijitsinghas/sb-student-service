package com.abhijits.studentservice.dto.transformer;

import org.springframework.stereotype.Component;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
public interface Transformer<TDomain, TDto> {

    TDto toDto (TDomain domain);

    TDomain toDomain (TDto dto);

}
