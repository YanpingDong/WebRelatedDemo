package com.dyp.JpaProject.persist.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dyp.JpaProject.config.JPAConfig;
import com.dyp.JpaProject.persist.entity.Authority;
import com.dyp.JpaProject.persist.entity.User;
import com.dyp.JpaProject.persist.service.dto.AuthorityDto;
import com.dyp.JpaProject.persist.service.dto.UserDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class })
public class GenericServiceTest {
	
	@Autowired
	private GenericService<User, UserDto, Long> userService;
	
	@Autowired
    private GenericService<Authority, AuthorityDto, Long> authorityService;
	
	@Test
	public void testFindOneUser() {
		UserDto userDto = userService.findOne(1L);
		Assert.assertNotNull(userDto);
		Assert.assertEquals(1, userDto.getId().longValue());
	}
	
	@Test
    public void testFindOneAuthority() {
        AuthorityDto authorityDto = authorityService.findOne(1L);
        Assert.assertNotNull(authorityDto);
        Assert.assertEquals(1, authorityDto.getId().longValue());
    }
	
	@Test
    public void testFindAll() {
        List<AuthorityDto> authorities = authorityService.findAll();
        Assert.assertFalse(authorities.isEmpty());
    }
	
	@Test
    public void testSave() {
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setName("test authority");
    }

}