package com.ktounsi.assessment.position.service;

import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import com.ktounsi.assessment.position.entity.Position;
import com.ktounsi.assessment.position.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@AllArgsConstructor
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    PositionRepository positionRepository;

    @Override
    public Position getById(Long id) {
        Optional<Position> optionalPosition = positionRepository.findById(id);
        if (optionalPosition.isEmpty()) throw new ObjectNotFoundException("not.found.address");
        return optionalPosition.get();
    }

    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position update(Position position) {
        Position positionDB = getById(position.getId());
        positionDB.setName(position.getName());
        return positionRepository.save(positionDB);
    }

    @Override
    public void delete(Long id) {
        Position positionDB = getById(id);
        positionRepository.delete(positionDB);
    }

}
