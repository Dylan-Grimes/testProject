package com.qa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.controller.TeamControllerTest;
import com.qa.service.TeamServiceTest;

@RunWith(Suite.class)
@SuiteClasses({TeamControllerTest.class, TeamServiceTest.class})
public class ControllerAndServiceSuite {

}
