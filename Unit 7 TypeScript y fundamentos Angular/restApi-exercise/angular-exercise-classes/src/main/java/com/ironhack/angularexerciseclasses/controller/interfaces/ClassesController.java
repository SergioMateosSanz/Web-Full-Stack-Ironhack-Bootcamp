package com.ironhack.angularexerciseclasses.controller.interfaces;

import com.ironhack.angularexerciseclasses.controller.dto.ClassesDTO;

import java.util.List;

public interface ClassesController {

    List<ClassesDTO> getAll();
}
