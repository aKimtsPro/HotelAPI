package com.example.hotelapi.service;

import java.util.List;

public interface BaseService <TDTO, TFORM, TUFORM, TID>{

   TDTO getOne(TID id);
   List<TDTO> getAll();

   TDTO insert(TFORM form);

   TDTO delete(TID id);

   TDTO update(TID id, TUFORM form);


}
