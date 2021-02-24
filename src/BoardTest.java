import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() throws Exception{
        board = new Board();
    }

    @Test
    @DisplayName("board size")
    public void boardShouldBe3x3(){
        assertEquals(3, board.getBoard().length);
        assertEquals(3, board.getBoard()[0].length);
    }

    @Test
    @DisplayName("verify start")
    public void boardShouldStartAllDash(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                assertEquals('-', board.getBoard()[i][j]);
            }
        }
    }

    @Test
    public void testMove(){
        assertTrue(board.move(1,2,'X'));
        assertFalse(board.move(3,4, 'X'));
    }

    @Test
    public void testColWin(){
        board.move(2,2, 'X');
        board.move(1,1, 'O');
        board.move(1,2, 'X');
        board.move(2,1, 'O');
        board.move(2,3, 'X');
        board.move(3,1, 'O');
        assertTrue(board.colWin());
    }

}
