package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import java.lang.reflect.Array;

import static org.hamcrest.core.Is.is;

public class BishopBlackTest{

    @Test
    public void whenStartPositionC1ThenPositionIsC1() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Assert.assertThat(bishopBlack.position(), is(startPosition));
    }

    @Test
    public void whenWayFromC1ToG5ThenWayIsD2E3F4G5() {
        Cell startPosition = Cell.C1;
        Cell destination = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell[] expectedWay = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(bishopBlack.way(destination), is(expectedWay));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayFromC1ToH3ThenException() {
        Cell startPosition = Cell.C1;
        Cell destination = Cell.H3;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        bishopBlack.way(destination);
    }

    @Test
    public void whenGoFromF1ToA6CopyNewPositionShouldBeA6() {
        Cell startPosition = Cell.F1;
        Cell destination = Cell.A6;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Assert.assertThat(bishopBlack.copy(destination).position(), is(destination));
    }
}