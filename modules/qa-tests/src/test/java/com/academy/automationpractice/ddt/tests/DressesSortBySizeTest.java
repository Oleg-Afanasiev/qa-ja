package com.academy.automationpractice.ddt.tests;

import org.testng.annotations.BeforeMethod;

public class DressesSortBySizeTest extends BaseTest{

    @BeforeMethod
    public void prepare() {
        manager.goTo().home();
        manager.session().login();
        manager.goTo().dresses();
    }
//
//    @Test(dataProvider = "sizes")
//    public void testDressSize(String size){
//        System.out.println("start 'testDressSize'");
//
//    }

//    @DataProvider (name = "sizes")
//    private Object[] getSizes(){
//
//
//    };

}
