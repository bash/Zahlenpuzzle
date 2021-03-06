package ruby.ninja.experiments.zahlenpuzzle.game;

import org.junit.Before;
import org.junit.Test;
import rubys.ninja.experiments.zahlenpuzzle.board.*;
import rubys.ninja.experiments.zahlenpuzzle.game.OneEmptyAndSortedNumericRuleEnforcer;
import rubys.ninja.experiments.zahlenpuzzle.game.RuleEnforcer;
import rubys.ninja.experiments.zahlenpuzzle.token.EmptyToken;
import rubys.ninja.experiments.zahlenpuzzle.token.NumericalToken;
import rubys.ninja.experiments.zahlenpuzzle.token.Token;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneEmptyAndSortedNumericRuleEnforcerTest {
    private Board board;
    private RuleEnforcer ruleEnforcer;
    private BoardSize emptyPos;

    @Before
    public void setup() throws Exception {
        board = new Board(new HardcodedInitializer());
        ruleEnforcer = new OneEmptyAndSortedNumericRuleEnforcer();
        emptyPos = new BoardSize(0, 0);
    }

    @Test
    public void testIsFinished() {
        Board finishedBoard = new Board(new SortedInitializer(new BoardSize(4, 4)));
        assertTrue(ruleEnforcer.isFinished(finishedBoard));
    }

    @Test
    public void testIsUnfinished() {
        Board finishedBoard = new Board(new HardcodedInitializer());
        assertFalse(ruleEnforcer.isFinished(finishedBoard));
    }

    @Test
    public void testNonMatchingTokens() {
        class MockInitializer implements BoardInitializer {
            @Override
            public List<Token> getTokens() {
                return new ArrayList<Token>() {{
                   add(new NumericalToken(1));
                   add(new NumericalToken(3));
                   add(new NumericalToken(2));
                   add(new EmptyToken());
                }};
            }

            @Override
            public BoardSize getBoardSize() {
                return new BoardSize(2, 2);
            }
        }

        Board finishedBoard = new Board(new MockInitializer());
        assertFalse(ruleEnforcer.isFinished(finishedBoard));
    }

    @Test
    public void testIsAllowedToSwapAdjacentEmpty() {
        BoardSize pos = new BoardSize(1, 0);
        assertTrue(ruleEnforcer.isAllowedToSwap(board, emptyPos, pos));
        assertTrue(ruleEnforcer.isAllowedToSwap(board, pos, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapAdjacentNumerical() {
        BoardSize pos1 = new BoardSize(2, 0);
        BoardSize pos2 = new BoardSize(1, 0);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos1, pos2));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos2, pos1));
    }

    @Test
    public void testIsNotAllowedToSwapSameEmpty() {
        assertFalse(ruleEnforcer.isAllowedToSwap(board, emptyPos, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapSameNumeric() {
        BoardSize pos = new BoardSize(1, 1);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos, pos));
    }

    @Test
    public void testIsNotAllowedToSwapNonAdjacentEmpty() {
        BoardSize pos = new BoardSize(1, 1);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, emptyPos, pos));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapNonAdjacentNumeric() {
        BoardSize pos1 = new BoardSize(1, 0);
        BoardSize pos2 = new BoardSize(2, 2);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos1, pos2));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos2, pos1));
    }

    @Test
    public void testIsNotAllowedToSwapNullWithEmpty() {
        assertFalse(ruleEnforcer.isAllowedToSwap(board, emptyPos, null));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, null, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapNullWithNumeric() {
        BoardSize pos = new BoardSize(1, 1);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, emptyPos, pos));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapOutOfBoundsWithEmpty() {
        BoardSize pos = new BoardSize(1000, 1000);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, emptyPos, pos));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos, emptyPos));
    }

    @Test
    public void testIsNotAllowedToSwapOutOfBoundsWithNumeric() {
        BoardSize pos1 = new BoardSize(1, 0);
        BoardSize pos2 = new BoardSize(1000, 1000);
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos1, pos2));
        assertFalse(ruleEnforcer.isAllowedToSwap(board, pos2, pos1));
    }
}
