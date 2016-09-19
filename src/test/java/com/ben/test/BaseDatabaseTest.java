/**
 * @version $Id: BaseDatabaseTest.java 7 2015-02-09 08:56:48Z enixjin $
 * Create date: Nov 27, 2013
 * Create by: enixjin
 */
package com.ben.test;

import com.ben.domain.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Base class for test against data base
 * Will use h2 in memory database, since it could easily be clean and rebuild and without side
 * effect.
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@SpringBootTest(classes = {AppConfig.class})
public abstract class BaseDatabaseTest extends AbstractJUnit4SpringContextTests {

    /**
     * method description goes here
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * method description goes here
     *
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

}
