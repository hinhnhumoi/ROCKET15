package org.VTI.Test;

import org.VTI.Entity.Account;
import org.VTI.Entity.Position;
import org.VTI.Repository.AccountRepository;
import org.VTI.Repository.PositionRepository;

import java.util.List;

public class PositionTest {
    public static void main(String[] args) {

        PositionRepository positionRepository = new PositionRepository();

//
//        Position positionCreate = new Position();
//        positionCreate.setName(PositionName.PM);
//        positionRepository.createPosition(positionCreate);

        List<Position> positions= positionRepository.getAllPosition();

        for (Position position: positions) {
            System.out.println(position);
        }
    }
}
