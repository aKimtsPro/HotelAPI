package com.example.hotelapi.service;

import com.example.hotelapi.exceptions.models.ElementNotFoundException;
import com.example.hotelapi.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractBaseService<TDTO, TFORM, TUFORM, TENTITY, TID> implements BaseService<TDTO, TFORM, TUFORM, TID> {

    protected final JpaRepository<TENTITY, TID> repository;
    protected final BaseMapper<TDTO, TFORM, TENTITY> mapper;

    protected AbstractBaseService(JpaRepository<TENTITY, TID> repository, BaseMapper<TDTO, TFORM, TENTITY> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TDTO getOne(TID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<TDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TDTO insert(TFORM form) {
        return mapper.toDto( repository.save(mapper.formToEntity(form)) );
    }

    @Override
    public TDTO delete(TID id) {

        TENTITY tentity = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);
        repository.delete(tentity);
        return mapper.toDto(tentity);

    }

    public abstract TDTO update(TID id, TUFORM form);
}
