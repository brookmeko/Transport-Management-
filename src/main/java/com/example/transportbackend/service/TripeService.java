package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.TripeDTO;

import java.util.List;
import java.util.UUID;

public interface TripeService {

    List<TripeDTO> getAllTripe();

    TripeDTO getTripeById(UUID id);

    boolean createTripe(TripeDTO TripeDTO);

    boolean updateTripe(TripeDTO TripeDTO);

    boolean deleteTripe(UUID id);
}
