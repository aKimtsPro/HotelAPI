package com.example.hotelapi.utils;

import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.entity.TypeChambre;
import com.example.hotelapi.models.entity.User;
import com.example.hotelapi.repository.ChambreRepository;
import com.example.hotelapi.repository.ClientRepository;
import com.example.hotelapi.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final UserRepository repository;
    private final ClientRepository clientRepository;
    private final ChambreRepository chambreRepository;
    private final PasswordEncoder encoder;

    public DatabaseFiller(UserRepository repository, ClientRepository clientRepository, ChambreRepository chambreRepository, PasswordEncoder encoder) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.chambreRepository = chambreRepository;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        saveUsers();
        saveRooms();
    }

    public void saveUsers(){
        User u = new User();
        u.setUsername("admin");
        u.setPassword( encoder.encode("pass")) ;
        u.setRoles(List.of( "ADMIN" ));

        repository.save( u );

        Client c = new Client();
        c.setUsername("user");
        c.setPassword( encoder.encode("pass")) ;
        c.setRoles(List.of( "CLIENT" ));
        c.setMoyenPayement(List.of("VISA"));
        c.setTel("0000000");
        c.setPrenom("luc");
        c.setNom("nom");

        clientRepository.save( c );
    }

    public void saveRooms(){

        Chambre c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(240);
        c.setNbrPlaces(2);
        c.setNumeroChambre(101);
        chambreRepository.save(c);

        c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(240);
        c.setNbrPlaces(2);
        c.setNumeroChambre(102);
        chambreRepository.save(c);

        c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(300);
        c.setNbrPlaces(3);
        c.setNumeroChambre(103);
        chambreRepository.save(c);

        c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(300);
        c.setNbrPlaces(3);
        c.setNumeroChambre(104);
        chambreRepository.save(c);

        c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(150);
        c.setNbrPlaces(1);
        c.setNumeroChambre(105);
        chambreRepository.save(c);

        c = new Chambre();
        c.setType(TypeChambre.SUITE);
        c.setPrix(150);
        c.setNbrPlaces(1);
        c.setNumeroChambre(106);
        chambreRepository.save(c);
    }
}
