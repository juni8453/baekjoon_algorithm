package backjoonsliver;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LinkedListTest {
    @Test
    void 제네릭스_학습테스트() throws Exception {
        List list = new ArrayList();
        list.add("This is String.");
        list.add(1);
        list.add(new Position(1, 2));

        String first = (String)list.get(0);
        int second = (int) list.get(1);
        Position third = (Position) list.get(2);
    }
}

