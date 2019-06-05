package com.pickrecalled.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pickrecalled.entity.Dept;

import feign.hystrix.FallbackFactory;

/**
 * Dept服务降级处理
 * @author PickRecalled
 */
@Component // 不要忘记添加此注解，否则不好使
public class DeptFeignServiceFallbackFactory implements FallbackFactory<DeptFeignService> {

	@Override
	public DeptFeignService create(Throwable arg0) {
		return new DeptFeignService() {

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public Dept get(Long id) {
				Dept dept = new Dept();
				dept.setDname("该ID：" + id + "无对应数据信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				dept.setDbSource("no this database in MySQL");
				return dept;
			}

			@Override
			public Boolean add(Dept dept) {
				return null;
			}
		};
	}

}
