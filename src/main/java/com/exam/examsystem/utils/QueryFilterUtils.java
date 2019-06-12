package com.exam.examsystem.utils;

import com.exam.examsystem.req.BaseRequest;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description of QueryFilterUtils
 *
 * @author max.sun
 * @version $$Id:$$
 * @created on 2018-04-23 11:06
 */
public class QueryFilterUtils {

	public static <T extends BaseRequest> T createQueryFilter(HttpServletRequest request, Class<T> clazz) {
		try {
			T queryFilter = clazz.cast(Class.forName(clazz.getName()).newInstance());
			populate(queryFilter, request);

			return queryFilter;
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private static <T extends BaseRequest> void populate(T bean, HttpServletRequest request) throws Exception {
		Map<String, String> map = new LinkedHashMap();
		Iterator i$ = request.getParameterMap().entrySet().iterator();
		while (i$.hasNext()) {
			Object entryObj = i$.next();
			Map.Entry<String, String[]> entry = (Map.Entry) entryObj;
			String name = entry.getKey();
			String[] values = entry.getValue();
			String value = values != null && values.length > 0 ? values[0] : null;
			map.put(name, value);
		}
		BeanUtils.populate(bean, map);
	}
}
