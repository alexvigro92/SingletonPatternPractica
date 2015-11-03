package mx.iteso.tables;

import mx.iteso.singleton.ChocolateBoiler;
import org.junit.After;
import org.junit.Test;

import java.lang.reflect.Field;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mavg_ on 11/2/2015.
 */
public class TestChocolateBoiler {
    @Test
    public void GetInstanceTest() {
        ChocolateBoiler boiler;
        boiler = ChocolateBoiler.getInstance();
        assertNotNull(boiler);
    }

    @Test
    public void SingletonSafeThreadTest() {
        ChocolateBoiler boiler;
        boiler = ChocolateBoiler.getInstance();
        assertEquals(boiler.isBoiled(), ChocolateBoiler.getInstance().isBoiled());
    }

    @Test
    public void FillTest(){
        ChocolateBoiler.getInstance().fill();
        assertEquals(false, ChocolateBoiler.getInstance().isEmpty());
    }

    @Test
    public void BoilTest()
    {
        ChocolateBoiler.getInstance().fill();
        ChocolateBoiler.getInstance().boil();
        assertEquals(true, ChocolateBoiler.getInstance().isBoiled());
    }

    @Test
    public void DrainTest(){
        ChocolateBoiler.getInstance().drain();
        assertEquals(true, ChocolateBoiler.getInstance().isEmpty());
    }

    @Test

    public void ErrorTest(){
        ChocolateBoiler.getInstance().fill();
        assertEquals(false, ChocolateBoiler.getInstance().isEmpty());
    }

    @After
    public void resetBoiler() throws NoSuchFieldException, IllegalAccessException {
        Field isBoiled = ChocolateBoiler.class.getDeclaredField("boiled");
        Field isEmpty = ChocolateBoiler.class.getDeclaredField("empty");

        isBoiled.setAccessible(true);
        isEmpty.setAccessible(true);

        isBoiled.setBoolean(ChocolateBoiler.getInstance(), false);
        isEmpty.setBoolean(ChocolateBoiler.getInstance(), true);
    }
}
