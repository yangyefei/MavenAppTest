package test.apptest;

import org.testng.Assert;
import org.testng.annotations.Test;



public class HelloWorld {
@Test
    public void f() {
        System.out.println("hello word");
        Assert.assertTrue(false);
    }

}