package com.test.treepay.repository;

import com.test.treepay.TestJavaDev;
import com.test.treepay.domain.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(TestJavaDev.class)
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testAddTodo() {
        Todo todoo = new Todo("02/12/2016", "Take a Cloths at Laundry");
        todoRepository.save(todoo);
        Todo t = todoRepository.findOne(todoo.getId());
        Assert.assertEquals(todoo.getId(),t.getId());
    }

    @Test
    public void testUpdateTodo() {
        Todo todoo = new Todo("02/12/2016", "Take a Cloths at Laundry");
        todoRepository.save(todoo);
        todoo.setDate("03/12/2016");
        todoRepository.save(todoo);
        Todo t = todoRepository.findOne(todoo.getId());
        Assert.assertEquals("03/12/2016",t.getDate());
    }
}
