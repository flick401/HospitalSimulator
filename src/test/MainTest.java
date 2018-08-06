package com.company;


import org.junit.Before;
import org.junit.Test;

public class MainTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturn2X() {
        Main main = new Main();
        String args[] = {"D,D", ""};
        main.main(args);
    }

    @Test
    public void shouldReturnOneH() {
        Main main = new Main();
        String args[] = {"F", "P"};
        main.main(args);
    }
}