package com.example.hotelapi.mapper;

public interface BaseMapper<TDTO, TFORM, TENTITY> {

    TDTO toDto(TENTITY entity);
    TENTITY formToEntity(TFORM form);

}
