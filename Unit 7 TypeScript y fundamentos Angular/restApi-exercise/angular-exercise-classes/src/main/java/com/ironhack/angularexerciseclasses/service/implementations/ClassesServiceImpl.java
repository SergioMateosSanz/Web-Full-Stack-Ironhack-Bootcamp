package com.ironhack.angularexerciseclasses.service.implementations;

import com.ironhack.angularexerciseclasses.controller.dto.ClassesDTO;
import com.ironhack.angularexerciseclasses.model.ClassesEntity;
import com.ironhack.angularexerciseclasses.repository.ClassesRepository;
import com.ironhack.angularexerciseclasses.service.intefaces.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public List<ClassesDTO> getAll() {

        List<ClassesEntity> classesEntityList = classesRepository.findAll();

        List<ClassesDTO> outputList = new ArrayList<>();

        for (ClassesEntity item: classesEntityList) {
            ClassesDTO classesDTO = new ClassesDTO();
            classesDTO.setId(item.getId());
            classesDTO.setTitle(item.getTitle());
            classesDTO.setDescription(item.getDescription());
            outputList.add(classesDTO);
        }
        return outputList;
    }
}
