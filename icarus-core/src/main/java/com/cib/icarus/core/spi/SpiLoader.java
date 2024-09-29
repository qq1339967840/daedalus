package com.cib.icarus.core.spi;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 用来帮助程序加载java-spi扩展
 * <br/>
 * 对于实现了{@link Ordered}的类可以按优先级返回实例对象
 *
 * @author goomba
 */
public class SpiLoader {

    public static <S> S loadFirst(Class<S> clazz) {
        Iterator<S> iterator = loadAll(clazz);
        if (!iterator.hasNext()) {
            throw new IllegalStateException(String.format(
                    "No implementation defined in /META-INF/services/%s, please check whether the file exists and has the right implementation class!",
                    clazz.getName()));
        }
        return iterator.next();
    }

    public static <S> Iterator<S> loadAll(Class<S> clazz) {
        ServiceLoader<S> loader = ServiceLoader.load(clazz);
        return loader.iterator();
    }

    public static <S extends Ordered> List<S> loadAllOrdered(Class<S> clazz) {
        Iterator<S> iterator = loadAll(clazz);
        List<S> candidates = Lists.newArrayList(iterator);
        candidates.sort(Comparator.comparingInt(Ordered::getOrder));
        return candidates;
    }

    public static <S extends Ordered> S loadPrimary(Class<S> clazz) {
        List<S> candidates = loadAllOrdered(clazz);
        if (candidates.isEmpty()) {
            throw new IllegalStateException(String.format(
                    "No implementation defined in /META-INF/services/%s, please check whether the file exists and has the right implementation class!",
                    clazz.getName()));
        }

        return candidates.get(0);
    }
}
