package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void changeState() {
        // given
        State state = State.ALIVE;

        // when
        state = state.changeState();

        // then
        assertEquals(state, State.DEAD);
    }
}