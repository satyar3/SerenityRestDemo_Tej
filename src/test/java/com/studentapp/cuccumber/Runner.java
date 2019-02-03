package com.studentapp.cuccumber;

import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


//Should be placed one step above Steps class
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
				features= {"src\\test\\resources\\feature\\"},
				glue = {"com.studentapp.cucumber.steps","com.studentapp.testbase"} 
				)
public class Runner extends TestBase
{
		
}
