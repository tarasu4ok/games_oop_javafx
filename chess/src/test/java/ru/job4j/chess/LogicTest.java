package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenMoveFromC1ToH6WithoutOtherFiguresThenSuccessMoveToH6()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        Figure figure = logic.move(Cell.C1, Cell.H6);
        Assert.assertThat(figure.position(), is(Cell.H6));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveFromF1ToB7ThenExceptionImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        logic.move(Cell.F1, Cell.B7);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveFromC1ToH6WithAnotherBishopOnE3ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveFromC1ToH6ButNoBishopOnC1ThenExceptionFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C2));
        logic.move(Cell.C1, Cell.H6);
    }
}