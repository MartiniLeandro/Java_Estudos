package com.mockito.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListClassTest {

    @Mock
    List<?> list;

    @Test
    void testMockList(){

        Mockito.when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

        Assertions.assertEquals(10, list.size());
        Assertions.assertEquals(20, list.size());
        Assertions.assertEquals(30, list.size());
    }
}
