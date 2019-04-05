package com.strategy;

import com.Shortener;
import com.utils.Helper;
import org.junit.Assert;
import org.junit.Test;

public class StrategyFunctionalTest {

    private void testStorage(Shortener shortener) {
        String string1 = Helper.generateRandomString();
        String string2 = Helper.generateRandomString();
        String string3 = string1;

        Long id1 = shortener.getId(string1);
        Long id2 = shortener.getId(string2);
        Long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id2, id3);

        Assert.assertEquals(id1, id3);

        String value1 = shortener.getString(id1);
        String value2 = shortener.getString(id2);

        Assert.assertEquals(value1, string1);
        Assert.assertEquals(value2, string2);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDataBaseStorageStrategy() {
        DataBaseStorageStrategy storageStrategy = new DataBaseStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        shortener.setLastId(storageStrategy.getLastID());
        testStorage(shortener);
    }
}
