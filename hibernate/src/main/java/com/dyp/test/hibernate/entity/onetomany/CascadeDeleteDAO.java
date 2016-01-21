package com.dyp.test.hibernate.entity.onetomany;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CascadeDeleteDAO<T> extends BaseDao<T>{

	@SuppressWarnings({ "rawtypes" })
	public void cascadeDel(Serializable id)
	{
		T one = get(id);
		for(Method method: one.getClass().getMethods())
		{
			CascadeDel cascadeDel = method.getAnnotation(CascadeDel.class);
			if( null != cascadeDel)
			{
				try {
					((List) method.invoke(one)).clear();
					save(one);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
