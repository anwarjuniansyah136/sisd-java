package com.sisd.init;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sisd.entity.Roles;
import com.sisd.repository.RolesRepository;
import com.sisd.constant.RolesConstant;

@Component
public class InitialDataLoader implements ApplicationRunner{

    @Autowired
    RolesRepository rolesrepository;


    @Override
    public void run(ApplicationArguments args) throws Exception{
        List<Roles> roles = rolesrepository.findAll();

        if(roles.isEmpty()){
            Roles  headmaster = new Roles(null,RolesConstant.HEADMASTER_ROLE,"role as headmaster in application");
            Roles  parent = new Roles(null,RolesConstant.PARENT_ROLE,"role as parent in application");
            Roles  teacher = new Roles(null,RolesConstant.TEACHER_ROLE,"role as teacher in application");

            rolesrepository.saveAll(List.of(headmaster,parent,teacher));
        }
    }
    
}