package com.ktounsi.assessment.position.service;

import com.ktounsi.assessment.position.entity.Position;

public interface PositionService {

    Position getById(Long id);

    Position savePosition(Position position);

    Position update(Position position);

   void delete(Long id);

}
