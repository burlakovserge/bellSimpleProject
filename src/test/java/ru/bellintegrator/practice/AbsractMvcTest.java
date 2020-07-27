package ru.bellintegrator.practice;


import org.junit.Ignore;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class AbsractMvcTest {
    protected MockMvc mockMvc;
    private static Set<Class> inited = new HashSet<>();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Before
    public void init() throws Exception {
        if (!inited.contains(getClass())) {
            doInit();
            inited.add(getClass());
        }
    }

    protected void doInit() throws Exception {
    }
}
