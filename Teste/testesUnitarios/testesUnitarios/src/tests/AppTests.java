package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import app.App;

public class AppTests {
    @Test
    public void helloWorld() {
        new App().somar(3, 2);

        Assert.assertEquals(4, new App().somar(2, 2));
    }
}
