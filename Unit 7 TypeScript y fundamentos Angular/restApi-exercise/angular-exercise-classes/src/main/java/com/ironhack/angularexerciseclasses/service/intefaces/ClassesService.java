package com.ironhack.angularexerciseclasses.service.intefaces;

import com.ironhack.angularexerciseclasses.controller.dto.ClassesDTO;

import java.util.List;

public interface ClassesService {

    List<ClassesDTO> getAll();
}
