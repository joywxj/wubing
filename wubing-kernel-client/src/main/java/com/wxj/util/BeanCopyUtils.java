package com.wxj.util;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>@ClassName: BeanCopyUtils  </p>
 * <p>@Description: </p>
 * <p>@author: wxj  </p>
 * <p>@date: 2020/10/19</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
public class BeanCopyUtils {
    public static <T, S extends Object> List<T> copyList(final Collection<S> sources, final Class<T> targetClass) {

        List<T> result = null;
        if (sources != null) {
            result = new ArrayList<T>();
            for (final Object object : sources) {
                final T t = copy(object, targetClass);
                result.add(t);
            }
        }
        return result;
    }
    /**
     * 复制属性
     *
     * @param source
     */
    public static <T> T copy(final Object source, final Class<T> targetClass) {

        T newInstance = null;
        if (source != null && targetClass != null) {

            try {
                newInstance = targetClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanCopier.create(source.getClass(), targetClass, false).copy(source, newInstance, null);

        }
        return newInstance;
    }
}
