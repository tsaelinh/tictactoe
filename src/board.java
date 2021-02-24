import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class board {
    public static void main(String[] args) {
        
    }

    public int sum(int x, int y){
        return x + y;
    }

    @Test
    public void testSum(){
        assertEquals(5, sum(3, 2));
    }
}
