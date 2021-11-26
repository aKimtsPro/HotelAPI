package com.example.hotelapi.controller;

import com.example.hotelapi.exceptions.FileNotReadableException;
import com.example.hotelapi.models.dto.VilleDTO;
import com.example.hotelapi.models.form.VilleDataForm;
import com.example.hotelapi.models.form.VilleForm;
import com.example.hotelapi.service.spec.VilleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/ville")
public class VilleController {

    private final VilleService service;

    public VilleController(VilleService service) {
        this.service = service;
    }

    @PostMapping("/test")
    private void test( @RequestParam(name = "file") MultipartFile file ){
        System.out.println(file);
    }

    @PostMapping
    private VilleDTO insert( @RequestParam MultipartFile file, @RequestParam String city_name){
        VilleForm form = new VilleForm();
        form.setNom( city_name );
        form.setImgType( file.getContentType() );

        try{
            form.setImgBytes( file.getBytes() );
        }catch (IOException ex){
            throw new FileNotReadableException();
        }

        return service.insert( form );
    }

    @GetMapping("/{id}")
    private VilleDTO getOne(@PathVariable long id){
        return service.getOne( id );
    }

    @PostMapping("/link")
    private VilleDTO insert(@Valid @RequestBody VilleDataForm form){
        return service.insert(form);
    }

}
